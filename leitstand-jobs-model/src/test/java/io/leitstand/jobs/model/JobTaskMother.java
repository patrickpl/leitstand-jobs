/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.jobs.service.TaskState.ACTIVE;
import static io.leitstand.jobs.service.TaskState.COMPLETED;
import static io.leitstand.jobs.service.TaskState.FAILED;
import static io.leitstand.jobs.service.TaskState.READY;
import static io.leitstand.jobs.service.TaskState.REJECTED;

public class JobTaskMother {

	public static Job_Task completedTask() {
		Job_Task task = new Job_Task();
		task.setTaskState(COMPLETED);
		return task;
	}

	public static Job_Task activeTask() {
		Job_Task task = new Job_Task();
		task.setTaskState(ACTIVE);
		return task;
	}

	public static Job_Task rejectedTask() {
		Job_Task task = new Job_Task();
		task.setTaskState(REJECTED);
		return task;
	}

	public static Job_Task failedTask() {
		Job_Task task = new Job_Task();
		task.setTaskState(FAILED);
		return task;
	}

	public static Job_Task readyTask() {
		Job_Task task = new Job_Task();
		task.setTaskState(READY);
		return task;
	}

	
	
	
}
