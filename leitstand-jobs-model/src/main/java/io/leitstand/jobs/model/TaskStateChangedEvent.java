/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

public class TaskStateChangedEvent implements StateChangedEvent{

	private Job_Task task;

	public TaskStateChangedEvent(Job_Task task){
		this.task = task;
	}
	
	public Job_Task getTask() {
		return task;
	}

	@Override
	public boolean isCompleted() {
		return task.isSucceeded();
	}

	@Override
	public boolean isCancelled() {
		return false;
	}

	@Override
	public boolean isFailed() {
		return task.isFailed();
	}

	@Override
	public boolean isTimedOut() {
		return task.isTimedOut();
	}

	@Override
	public boolean isRejected() {
		return task.isRejected();
	}

	@Override
	public boolean isActive() {
		return task.isActive();
	}

	@Override
	public boolean isReady() {
		return task.isReady();
	}
	
	
}
