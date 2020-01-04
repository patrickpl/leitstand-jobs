/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.jobs.model.JobTaskMother.activeTask;
import static io.leitstand.jobs.model.JobTaskMother.completedTask;
import static io.leitstand.jobs.model.JobTaskMother.failedTask;
import static io.leitstand.jobs.model.JobTaskMother.readyTask;
import static io.leitstand.jobs.model.JobTaskMother.rejectedTask;
import static io.leitstand.jobs.service.JobId.randomJobId;
import static io.leitstand.jobs.service.TaskState.COMPLETED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import io.leitstand.jobs.service.JobApplication;
import io.leitstand.jobs.service.JobName;
import io.leitstand.jobs.service.JobType;
import io.leitstand.security.auth.UserId;

public class JobTest {
	
	private Job job;
	
	@Before
	public void prepareJob() {
		job = new Job(JobApplication.valueOf("junit"),
				      JobType.valueOf("test"),
				      randomJobId(),
				      JobName.valueOf("test"),
				      UserId.valueOf("unittest"));
	}

	@Test
	public void cannot_complete_job_with_failed_tasks() {
		job.addTask(completedTask());
		job.addTask(failedTask());
		assertFalse(job.completed());
	}
	
	@Test
	public void cannot_complete_job_with_ready_tasks() {
		job.addTask(completedTask());
		job.addTask(readyTask());
		assertFalse(job.completed());
	}

	@Test
	public void cannot_complete_job_with_active_tasks() {
		job.addTask(completedTask());
		job.addTask(activeTask());
		assertFalse(job.completed());
	}
	
	@Test
	public void cannot_complete_job_with_rejected_tasks() {
		job.addTask(completedTask());
		job.addTask(rejectedTask());
		assertFalse(job.completed());
	}

	
	@Test
	public void can_complete_job_with_completed_tasks() {
		job.addTask(completedTask());
		job.addTask(completedTask());
		assertTrue(job.completed());
		assertEquals(COMPLETED,job.getJobState());
	}
	
	
	
}
