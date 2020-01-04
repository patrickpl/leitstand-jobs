/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.jobs.service.JobId.randomJobId;
import static io.leitstand.jobs.service.TaskId.randomTaskId;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.junit.Before;
import org.junit.Test;

import io.leitstand.jobs.service.JobName;
import io.leitstand.jobs.service.TaskState;

public class TaskProcessingServiceTest {

	static JsonObject asJson(String message) {
		try(JsonReader reader = Json.createReader(new StringReader(message))) {
			return reader.readObject();
		}
	}
	
	
	private TaskProcessingService service;
	private TaskProcessorDiscoveryService processors;
	private Job_Task task;
	private Job job;
	private TaskProcessor processor;
	
	
	@Before
	public void initTestResources() {
		processors = mock(TaskProcessorDiscoveryService.class);
		service = new TaskProcessingService(processors);
		job = mock(Job.class);
		when(job.getJobId()).thenReturn(randomJobId());
		when(job.getJobName()).thenReturn(JobName.valueOf("unit-job_name"));
		task = mock(Job_Task.class);
		when(task.getJob()).thenReturn(job);
		when(task.getTaskId()).thenReturn(randomTaskId());
		processor = mock(TaskProcessor.class);
		when(processors.findElementTaskProcessor(task)).thenReturn(processor);
	}
	
	
	@Test
	public void do_nothing_if_task_is_blocked() {
		doReturn(Boolean.TRUE).when(task).isBlocked();
		service.execute(task);
		verify(processors,never()).findElementTaskProcessor(task);
	}
	
	@Test
	public void process_unblocked_non_element_task() {
		assertFalse(task.isBlocked());
		service.execute(task);
		verify(processors).findElementTaskProcessor(task);
		verify(task,never()).setTaskState(TaskState.COMPLETED);
	}	
	
	@Test
	public void process_unblocked_element_task() {
		when(task.isElementTask()).thenReturn(Boolean.TRUE);
		assertFalse(task.isBlocked());
		service.execute(task);
		verify(processors).findElementTaskProcessor(task);
		verify(processor).execute(task);
		verify(task,never()).setTaskState(TaskState.COMPLETED);
	}
	
}


