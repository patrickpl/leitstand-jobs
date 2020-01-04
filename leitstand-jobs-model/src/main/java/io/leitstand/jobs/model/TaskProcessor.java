/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import io.leitstand.jobs.service.TaskState;

/**
 * A <code>TaskProcessor</code> processes a single task of a {@link Job}.
 * <p>
 * Every application that creates jobs can provide task processors to process the tasks of the job.
 * By that, the job scheduler is fully extensible with respect to how to handle task.
 * An application must implement {@link ElementTaskProcessors} to expose all existing task processors.
 * </p>
 */
public interface TaskProcessor {
	
	TaskState execute(Job_Task task);
	
}
