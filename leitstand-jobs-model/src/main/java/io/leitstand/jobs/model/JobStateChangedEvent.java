/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.jobs.service.TaskState.READY;

import io.leitstand.jobs.service.TaskState;

public class JobStateChangedEvent implements StateChangedEvent {

	private Job job;

	public JobStateChangedEvent(Job job){
		this.job = job;
	}
	
	public Job getJob() {
		return job;
	}
	
	@Override
	public boolean isTimedOut(){
		return job.isTimedOut();
	}
	
	public boolean isTerminated(){
		return job.isTerminated();
	}
	
	public boolean isSubmitted(){
		return job.isSubmitted();
	}

	@Override
	public boolean isFailed(){
		return job.isFailed();
	}

	@Override
	public boolean isCompleted(){
		return job.isCompleted();
	}

	@Override
	public boolean isCancelled() {
		return job.isCancelled();
	}

	@Override
	public boolean isRejected() {
		return job.isInState(TaskState.REJECTED);
	}

	@Override
	public boolean isActive() {
		return job.isRunning();
	}

	@Override
	public boolean isReady() {
		return job.isInState(READY);
	}
	
}
