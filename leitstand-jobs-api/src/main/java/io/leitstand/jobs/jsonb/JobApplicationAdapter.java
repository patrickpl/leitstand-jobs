/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jsonb;

import javax.json.bind.adapter.JsonbAdapter;

import io.leitstand.jobs.service.JobApplication;

public class JobApplicationAdapter implements JsonbAdapter<JobApplication,String> {

	@Override
	public JobApplication adaptFromJson(String v) throws Exception {
		return JobApplication.valueOf(v);
	}

	@Override
	public String adaptToJson(JobApplication v) throws Exception {
		return JobApplication.toString(v);
	}



}
