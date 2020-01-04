/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.flow;

import java.util.List;

import javax.inject.Inject;

import io.leitstand.commons.flow.ControlFlow;
import io.leitstand.jobs.service.JobId;
import io.leitstand.jobs.service.JobTaskService;
import io.leitstand.jobs.service.TaskId;
import io.leitstand.jobs.service.TaskState;


@ControlFlow
public class TaskUpdateFlow {

	private JobTaskService service;
	
	@Inject
	public TaskUpdateFlow(JobTaskService service) {
		this.service = service;
	}
	
	public void processTask(JobId jobId,
							TaskId taskId, 
							TaskState state) {
		for(TaskId successor : updateTask(jobId,
										  taskId, 
										  state, 
										  2)) {
			executeTask(jobId,
						successor,
						2);
		}
	}

	private void executeTask(JobId jobId,
							 TaskId successor, 
							 int retryPermits) {
		try {
			service.executeTask(jobId,
								successor);
		} catch (Exception e) {
			if(--retryPermits == 0) {
				throw e;
			}
			executeTask(jobId,
						successor, 
						retryPermits);
		}
	}

	private List<TaskId> updateTask(JobId jobId, 
									TaskId taskId,
									TaskState state, 
									int retryPermits) {
		try {
			return service.updateTask(jobId,
									  taskId,
									  state);
		} catch (Exception e) {
			if(--retryPermits == 0) {
				throw e;
			}
			return updateTask(jobId,
							  taskId, 
							  state, 
							  retryPermits);
		}
	}
	
}