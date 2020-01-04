/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import static io.leitstand.commons.model.BuilderUtil.assertNotInvalidated;

import javax.json.bind.annotation.JsonbProperty;

import io.leitstand.commons.model.ValueObject;
import io.leitstand.inventory.service.ElementGroupId;
import io.leitstand.inventory.service.ElementGroupName;
import io.leitstand.security.auth.UserId;


public class BaseJobEnvelope extends ValueObject {

	public static class BaseJobEnvelopeBuilder<T extends BaseJobEnvelope, B extends BaseJobEnvelope.BaseJobEnvelopeBuilder<T,B>>{
		
		protected T object;
		
		protected BaseJobEnvelopeBuilder(T object) {
			this.object = object;
		}
		
		public B withGroupId(ElementGroupId groupId) {
			assertNotInvalidated(getClass(), object);
			((BaseJobEnvelope)object).groupId = groupId;
			return (B) this;
		}
		
		public B withGroupName(ElementGroupName groupName) {
			assertNotInvalidated(getClass(), object);
			((BaseJobEnvelope)object).groupName = groupName;
			return (B) this;
		}
		
		public B withJobApplication(JobApplication application) {
			assertNotInvalidated(getClass(), object);
			((BaseJobEnvelope)object).jobApplication = application;
			return (B) this;
		}
		
		public B withJobType(JobType type) {
			assertNotInvalidated(getClass(), object);
			((BaseJobEnvelope)object).jobType = type;
			return (B) this;
		}
		
		public B withJobName(JobName name) {
			assertNotInvalidated(getClass(), object);
			((BaseJobEnvelope)object).jobName = name;
			return (B) this;
		}
		
		public B withJobId(JobId jobId) {
			assertNotInvalidated(getClass(), object);
			((BaseJobEnvelope)object).jobId = jobId;
			return (B) this;
		}
		
		public B withJobState(TaskState state) {
			assertNotInvalidated(getClass(), object);
			((BaseJobEnvelope)object).jobState = state;
			return (B) this;
		}
		
		public B withJobOwner(UserId userId) {
			assertNotInvalidated(getClass(), object);
			((BaseJobEnvelope)object).jobOwner = userId;
			return (B) this;
		}
		
		public T build() {
			try {
				assertNotInvalidated(getClass(), object);
				return object;
			} finally {
				object = null;
			}
		}
		
	}
	
	
	@JsonbProperty("group_id")
	private ElementGroupId groupId;

	@JsonbProperty("group_name")
	private ElementGroupName groupName;

	@JsonbProperty("job_id")
	private JobId jobId;

	@JsonbProperty("job_name")
	private JobName jobName;

	@JsonbProperty("job_type")
	private JobType jobType;
	
	@JsonbProperty("job_application")
	private JobApplication jobApplication;
	
	@JsonbProperty("job_owner")
	private UserId jobOwner;
	@JsonbProperty("job_state")
	private TaskState jobState;

	public JobId getJobId() {
		return jobId;
	}

	public JobName getJobName() {
		return jobName;
	}

	public UserId getJobOwner() {
		return jobOwner;
	}

	public TaskState getJobState() {
		return jobState;
	}
	
	public JobApplication getJobApplication() {
		return jobApplication;
	}
	
	public JobType getJobType() {
		return jobType;
	}

	public ElementGroupId getGroupId() {
		return groupId;
	}
	
	public ElementGroupName getGroupName() {
		return groupName;
	}
	
}
