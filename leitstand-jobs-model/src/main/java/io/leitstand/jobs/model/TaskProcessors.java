/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import io.leitstand.jobs.service.JobApplication;
import io.leitstand.jobs.service.JobType;
import io.leitstand.jobs.service.TaskType;

public class TaskProcessors {

	public static TaskProcessors application(JobApplication application) {
		return new TaskProcessors(application);
	}
	
	private JobApplication jobApplication;
	private JobType jobType;
	private TaskProcessor defaultTaskProcessor;
	private Map<TaskType,TaskProcessor> taskProcessors;
	
	protected TaskProcessors() {
		// CDI
	}
	
	protected TaskProcessors(JobApplication jobApplication) {
		this.jobApplication = jobApplication;
		this.taskProcessors = new HashMap<>();
	}
	
	public TaskProcessors jobType(JobType jobType) {
		this.jobType = jobType;
		return this;
	}

	public TaskProcessors taskProcessor(TaskType taskType, Supplier<TaskProcessor> taskProcessor) {
		taskProcessors.put(taskType,taskProcessor.get());
		return this;
	}
	
	public TaskProcessors taskProcessor(TaskType taskType, TaskProcessor taskProcessor) {
		taskProcessors.put(taskType,taskProcessor);
		return this;
	}

	public TaskProcessors defaultProcessor(TaskProcessor processor) {
		this.defaultTaskProcessor = processor;
		return this;
	}
	
	public boolean providesTaskProcessorsFor(JobApplication jobApplication, JobType jobType) {
		if(this.jobApplication.equals(jobApplication)) {
			return this.jobType == null || this.jobType.equals(jobType);
		}
		return false;
	}
	
	public TaskProcessor getTaskProcessor(TaskType taskType) {
		TaskProcessor taskProcessor = taskProcessors.get(taskType);
		if(taskProcessor != null) {
			return taskProcessor;
		}
		return defaultTaskProcessor;
	}

}