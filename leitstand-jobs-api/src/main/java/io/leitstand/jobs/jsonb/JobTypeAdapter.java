/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jsonb;

import javax.json.bind.adapter.JsonbAdapter;

import io.leitstand.jobs.service.JobType;

public class JobTypeAdapter implements JsonbAdapter<JobType,String> {

	@Override
	public JobType adaptFromJson(String v) throws Exception {
		return JobType.valueOf(v);
	}

	@Override
	public String adaptToJson(JobType v) throws Exception {
		return JobType.toString(v);
	}



}
