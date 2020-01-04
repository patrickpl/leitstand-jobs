/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;


@ApplicationScoped
public class TaskProcessorDiscoveryService {

	@Inject
	private Instance<TaskProcessors> processors;
	
	public TaskProcessor findElementTaskProcessor(Job_Task task) {
		for(TaskProcessors tasks : processors) {
			if(tasks.providesTaskProcessorsFor(task.getJobApplication(), task.getJobType())) {
				return tasks.getTaskProcessor(task.getTaskType());
			}
		}
		return null;
	}
	
}