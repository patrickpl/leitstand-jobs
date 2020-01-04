/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import java.util.Date;

import io.leitstand.commons.model.ValueObject;

public class JobQuery extends ValueObject{

	public static Builder newJobQuery() {
		return new Builder();
	}
	
	public static class Builder {
		private JobQuery query = new JobQuery();
		
		public Builder withFilter(String filter) {
			query.filter = filter;
			return this;
		}
		
		public Builder withRunningOnly(boolean runningOnly) {
			query.runningOnly = runningOnly;
			return this;
		}
		
		public Builder withScheduledAfter(Date after) {
			query.scheduledAfter = after;
			return this;
		}
		
		public Builder withScheduledBefore(Date before) {
			query.scheduledBefore = before;
			return this;
		}
		
		public JobQuery build() {
			try {
				return query;
			} finally {
				this.query = null;
			}
		}
	}
	
	private String filter;
	private boolean runningOnly;
	private Date scheduledAfter;
	private Date scheduledBefore;

	public String getFilter() {
		return filter;
	}
	
	public boolean isRunningOnly() {
		return runningOnly;
	}
	
	public Date getScheduledAfter() {
		if(scheduledAfter == null) {
			return null;
		}
		return new Date(scheduledAfter.getTime());
	}
	
	public Date getScheduledBefore() {
		if(scheduledBefore == null) {
			return null;
		}
		return new Date(scheduledBefore.getTime());
	}
	
}