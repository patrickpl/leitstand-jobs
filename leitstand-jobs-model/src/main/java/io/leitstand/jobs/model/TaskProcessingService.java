/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.jobs.service.TaskState.COMPLETED;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import io.leitstand.jobs.service.TaskState;

@Dependent
public class TaskProcessingService  {
	
	private TaskProcessorDiscoveryService processors;
	
	@Inject
	public TaskProcessingService(TaskProcessorDiscoveryService processors) {
		this.processors = processors;
	}
	
	public List<Job_Task> execute(Job_Task task){
		if(task.isBlocked()){
			// Blocked tasks must not be executed by an executor.
			// This is a safety mechanism to avert an 
			// accidental execution of a blocked task.
			return emptyList();
		}
		
		// Load the task processor for the specified task...
		TaskProcessor processor = processors.findElementTaskProcessor(task);

		TaskState state = COMPLETED;
		if(processor != null) {
			state = processor.execute(task);
		}
		
		// An executable task with no processor is either
		// a fork task, that has to be completed in order to fork the task flow into multiple branches or
		// a join task, where all predecessors have been completed (otherwise the task would be blocked)
		// that has to be completed in order to process the successor.
		// In summary: an executable task without processor is done as per definition.
		task.setTaskState(state);
		if(task.isSucceeded()) {
			return task.getSuccessors()
					   .stream()
					   .map(Job_Task_Transition::getTo)
					   .collect(toList());
		}
		if(task.isFailed()) {
			task.getJob().failed();
		}
		
		return emptyList();

	
	}

}