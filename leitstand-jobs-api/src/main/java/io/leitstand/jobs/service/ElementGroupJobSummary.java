/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import java.util.Date;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;

import io.leitstand.commons.jsonb.IsoDateAdapter;
import io.leitstand.commons.model.ValueObject;
import io.leitstand.security.auth.UserId;

public class ElementGroupJobSummary extends ValueObject {
	
	public static Builder newElementGroupJobSummary(){
		return new Builder();
	}
	
	public static class Builder {
		private ElementGroupJobSummary job = new ElementGroupJobSummary();
		
		public Builder withJobId(JobId jobId){
			job.jobId = jobId;
			return this;
		}

		public Builder withJobName(JobName name){
			job.jobName = name;
			return this;
		}

		public Builder withTaskState(TaskState state){
			job.jobState = state;
			return this;
		}

		public Builder withJobOwner(UserId userId){
			job.jobOwner = userId;
			return this;
		}

		public Builder withStartDate(Date startDate){
			job.startDate = startDate;
			return this;
		}
		
		public ElementGroupJobSummary build(){
			try{
				return job;
			} finally {
				this.job = null;
			}
		}
		
	}
	
	@JsonbProperty("job_id")
	private JobId jobId;
	
	@JsonbProperty("job_name")
	private JobName jobName;
	
	@JsonbProperty
	private UserId jobOwner;
	
	@JsonbProperty("job_state")
	private TaskState jobState;
	
	@JsonbProperty("date_scheduled")
	@JsonbTypeAdapter(IsoDateAdapter.class)
	private Date startDate;
	
	public JobId getJobId() {
		return jobId;
	}
	
	public JobName getJobName() {
		return jobName;
	}

	public TaskState getJobState() {
		return jobState;
	}
	
	public UserId getJobOwner() {
		return jobOwner;
	}
	
	public Date getStartDate() {
		return new Date(startDate.getTime());
	}
	
}
