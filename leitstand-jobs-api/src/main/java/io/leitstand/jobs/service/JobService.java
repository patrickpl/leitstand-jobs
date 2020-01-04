/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import java.util.List;

public interface JobService {
	
	void cancelJob(JobId jobId);
	
	void commitJob(JobId jobId);
	
	List<TaskId> confirmJob(JobId jobId);
	
	List<JobSettings> findJobs(JobQuery query);
	
	JobFlow getJobFlow(JobId jobId);
	
	JobInfo getJobInfo(JobId id);
	
	JobProgress getJobProgress(JobId id);
	
	JobSettings getJobSettings(JobId jobId);
	
	JobSubmission getJobSubmission(JobId jobId);
	
	JobTasks getJobTasks(JobId jobId);
	
	void removeJob(JobId jobId);
	
	List<TaskId> resumeJob(JobId jobId);
	
	void storeJob(JobId jobId, JobSubmission submission);

	void storeJobSettings(JobId jobId, JobSettings settings);
	
	void updateJobState(JobId jobId, TaskState state);

}
