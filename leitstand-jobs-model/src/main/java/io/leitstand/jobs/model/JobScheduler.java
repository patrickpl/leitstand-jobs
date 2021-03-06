/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.jobs.model.Job.findByJobId;
import static io.leitstand.jobs.model.Job.findRunnableJobs;
import static io.leitstand.jobs.service.TaskState.ACTIVE;
import static io.leitstand.jobs.service.TaskState.FAILED;
import static java.lang.String.format;
import static java.util.logging.Level.FINER;
import static java.util.stream.Collectors.toList;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import io.leitstand.commons.model.Repository;
import io.leitstand.commons.model.Service;
import io.leitstand.jobs.service.JobId;
import io.leitstand.jobs.service.JobTaskService;
import io.leitstand.jobs.service.TaskId;

@Service
public class JobScheduler {
	
	private static final Logger LOG = Logger.getLogger(JobScheduler.class.getName());
	
	@Inject
	@Jobs
	private Repository repository;

	@Inject
	private JobTaskService service;
	
	@Inject
	private Event<JobStateChangedEvent> jobStateEventSink;
	
	public List<JobId> findJobs(){
		Date now = new Date();
		return repository.execute(findRunnableJobs(now))
						 .stream()
						 .map(Job::getJobId)
						 .collect(toList());
	}
	
	public void schedule(JobId jobId){
		Job job = repository.execute(findByJobId(jobId));
		try{
			job.setJobState(ACTIVE);
			jobStateEventSink.fire(new JobStateChangedEvent(job));
			List<TaskId> tasks = service.executeTask(job.getJobId(),
													 job.getStart().getTaskId());
			while(!tasks.isEmpty()) {
				List<TaskId> successors = new LinkedList<>();
				for(TaskId taskId : tasks) {
					successors.addAll(service.executeTask(job.getJobId(),
														  taskId));
				}
				tasks = successors;
			}
			job.completed();
		} catch (Exception e){
			job.setJobState(FAILED);
			jobStateEventSink.fire(new JobStateChangedEvent(job));
			LOG.info(()->format("Cannot start job %s (%s): %s",
							    job.getJobName(),
								job.getJobId(),
								e.getMessage()));
			LOG.log(FINER,e.getMessage(),e);
		}
	}
}
