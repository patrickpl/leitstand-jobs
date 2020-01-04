/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.jobs.model.Job_Task.findByTaskId;
import static io.leitstand.jobs.model.Job_Task.markExpiredTasks;
import static io.leitstand.jobs.service.TaskState.TIMEOUT;

import java.util.Date;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import io.leitstand.commons.model.Repository;
import io.leitstand.commons.model.Service;
import io.leitstand.jobs.service.TaskId;

@Service
public class TaskExpiryManager {
	
	@Inject
	private Event<TaskStateChangedEvent> taskEventSink;
	
	@Inject
	@Jobs
	private Repository repository;
	
	public void taskTimedout(Date expired) {
		repository.execute(markExpiredTasks(expired));
	}

	public void taskTimedout(TaskId taskId){
		Job_Task task = repository.execute(findByTaskId(taskId));
		task.setTaskState(TIMEOUT);
		taskEventSink.fire(new TaskStateChangedEvent(task));
	}
	
}