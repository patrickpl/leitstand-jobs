/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import static io.leitstand.commons.model.BuilderUtil.assertNotInvalidated;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

import java.util.LinkedList;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

public class JobTasks extends BaseJobEnvelope{

	public static Builder newJobTasks() {
		return new Builder();
	}
	
	public static class Builder extends BaseJobEnvelopeBuilder<JobTasks, Builder>{
		
		public Builder() {
			super(new JobTasks());
		}

		public Builder withOwner(String owner) {
			assertNotInvalidated(getClass(),object);
			object.owner = owner;
			return this;
		}
		
		public Builder withTasks(JobTask... tasks) {
			return withTasks(asList(tasks));
		}		
		
		public Builder withTasks(JobTask.JobTaskBuilder... tasks) {
			return withTasks(stream(tasks)
					         .map(JobTask.JobTaskBuilder::build)
					         .collect(toList()));
		}
		
		public Builder withTasks(List<JobTask> tasks) {
			assertNotInvalidated(getClass(), object);
			object.tasks = unmodifiableList(new LinkedList<>(tasks));
			return this;
		}
		
	}
	
	@JsonbProperty("job_owner")
	private String owner;
	private List<JobTask> tasks;
	
	public List<JobTask> getTasks() {
		return tasks;
	}
	
	public String getOwner() {
		return owner;
	}
	
}
