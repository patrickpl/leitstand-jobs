/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import java.util.List;

public interface JobTaskService {
	List<TaskId> updateTask(JobId jobId, TaskId taskId, TaskState state);
	JobTaskInfo getJobTask(JobId jobId, TaskId taskId);
	List<TaskId> executeTask(JobId jobId, TaskId taskId);
}
