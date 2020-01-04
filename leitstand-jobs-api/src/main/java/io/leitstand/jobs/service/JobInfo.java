/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import static io.leitstand.commons.model.BuilderUtil.assertNotInvalidated;
import static java.util.Collections.unmodifiableList;

import java.util.LinkedList;
import java.util.List;

public class JobInfo extends BaseJobEnvelope{

	public static Builder newJobInfo(){
		return new Builder();
	}

	public static class Builder extends BaseJobEnvelopeBuilder<JobInfo, Builder> {
		
		public Builder() {
			super(new JobInfo());
		}

		public Builder withSchedule(JobSchedule schedule){
			assertNotInvalidated(getClass(), object);
			object.schedule = schedule;
			return this;
		}
		
		public Builder withTasks(List<JobTask> tasks){
			assertNotInvalidated(getClass(), object);
			object.tasks = unmodifiableList(new LinkedList<>(tasks));
			return this;
		}
		
		public Builder withProgress(JobProgress progress) {
			assertNotInvalidated(getClass(), object);
			object.progress = progress;
			return this;
		}
		
		public Builder withSchedule(JobSchedule.Builder scheduler) {
			return withSchedule(scheduler.build());
		}

		@Override
		public JobInfo build(){
			try{
				assertNotInvalidated(getClass(), object);
				return object;
			} finally {
				this.object = null;
			}
		}

	}

	private JobProgress progress;
	
	private JobSchedule schedule;
	
	private List<JobTask> tasks;


	public JobSchedule getSchedule() {
		return schedule;
	}
	
	public List<JobTask> getTasks() {
		return unmodifiableList(tasks);
	}
	
	public JobProgress getProgress() {
		return progress;
	}	
	
}
