/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import javax.json.bind.annotation.JsonbProperty;

import io.leitstand.commons.model.ValueObject;

public class JobProgress extends ValueObject {


	public static Builder newJobProgress() {
		return new Builder();
	}

	public static class Builder{
		
		private JobProgress progress = new JobProgress();
		
		public Builder withReadyCount(int count) {
			this.progress.readyCount = count;
			return this;
		}

		public Builder withActiveCount(int count) {
			this.progress.activeCount = count;
			return this;
		}
		
		public Builder withCompletedCount(int count) {
			this.progress.completedCount = count;
			return this;
		}
		
		public Builder withFailedCount(int count) {
			this.progress.failedCount = count;
			return this;
		}
		
		public Builder withTimeoutCount(int count) {
			this.progress.timeoutCount = count;
			return this;
		}
		
		public JobProgress build() {
			try {
				return this.progress;
			} finally {
				this.progress = null;
			}
		}
	}
	
	@JsonbProperty("ready")
	private int readyCount;
	@JsonbProperty("active")
	private int activeCount;
	@JsonbProperty("completed")
	private int completedCount;
	@JsonbProperty("failed")
	private int failedCount;
	@JsonbProperty("timeout")
	private int timeoutCount;
	
	public int getReadyCount() {
		return readyCount;
	}
	
	public int getActiveCount() {
		return activeCount;
	}
	
	public int getCompletedCount() {
		return completedCount;
	}
	
	public int getFailedCount() {
		return failedCount;
	}
	
	public int getTimeoutCount() {
		return timeoutCount;
	}

	
	
	
	
}
