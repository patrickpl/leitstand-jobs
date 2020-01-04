/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import java.util.Date;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;

import io.leitstand.commons.jsonb.IsoDateAdapter;
import io.leitstand.commons.model.ValueObject;

public class JobSchedule extends ValueObject{
	
	public static Builder newJobSchedule(){
		return new Builder();
	}

	public static class Builder{
		private JobSchedule schedule = new JobSchedule();
		
		public Builder withStartTime(Date startTime){
			schedule.dateScheduled = new Date(startTime.getTime());
			return this;
		}
		
		public Builder withEndTime(Date endTime){
			schedule.dateSuspend = endTime != null ? new Date(endTime.getTime()) : null;
			return this;
		}
		
		public Builder withAutoResume(boolean autoResume){
			schedule.autoResume = autoResume;
			return this;
		}
		
		public JobSchedule build(){
			try{
				return schedule;
			} finally {
				this.schedule = null;
			}
		}
	}
	
	@JsonbProperty("date_scheduled")
	@JsonbTypeAdapter(IsoDateAdapter.class)
	private Date dateScheduled;

	@JsonbProperty("date_suspend")
	@JsonbTypeAdapter(IsoDateAdapter.class)
	private Date dateSuspend;
	
	@JsonbProperty("auto_resume")
	private boolean autoResume;
	
	public Date getDateScheduled() {
		if(dateScheduled == null) {
			return null;
		}
		return new Date(dateScheduled.getTime());
	}
	
	public Date getDateSuspend() {
		if(dateSuspend == null) {
			return null;
		}
		return new Date(dateSuspend.getTime());
	}
	
	public boolean isAutoResume() {
		return autoResume;
	}

}