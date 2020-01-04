/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.jobs.service.TaskState.COMPLETED;

import io.leitstand.jobs.service.TaskState;

public final class NoopTaskProcessor implements TaskProcessor {

	private static final NoopTaskProcessor INSTANCE = new NoopTaskProcessor();
	
	public static NoopTaskProcessor completeTask() {
		return INSTANCE;
	}
	
	private NoopTaskProcessor() {
		// Singleton
	}
	
	@Override
	public TaskState execute(Job_Task task) {
		return COMPLETED;
	}

}
