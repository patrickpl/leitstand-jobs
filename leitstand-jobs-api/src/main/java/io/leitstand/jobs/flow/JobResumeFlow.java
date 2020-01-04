/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.flow;

import javax.inject.Inject;

import io.leitstand.commons.flow.ControlFlow;
import io.leitstand.jobs.service.JobId;
import io.leitstand.jobs.service.JobService;
import io.leitstand.jobs.service.JobTaskService;
import io.leitstand.jobs.service.TaskId;


@ControlFlow
public class JobResumeFlow {

	private JobService jobService;
	private JobTaskService taskService;
	
	@Inject
	public JobResumeFlow(JobService jobService, JobTaskService taskService) {
		this.jobService = jobService;
		this.taskService = taskService;
	}
	
	public void resumeJob(JobId jobId) {
		for(TaskId task : jobService.resumeJob(jobId)) {
			executeTask(jobId, task, 2);
		}
		
	}

	private void executeTask(JobId jobId, TaskId successor, int retryPermits) {
		try {
			taskService.executeTask(jobId,successor);
		} catch (Exception e) {
			if(--retryPermits == 0) {
				throw e;
			}
			executeTask(jobId,successor, retryPermits);
		}
	}


	
}