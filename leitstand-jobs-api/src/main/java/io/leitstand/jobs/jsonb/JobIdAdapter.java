/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jsonb;

import javax.json.bind.adapter.JsonbAdapter;

import io.leitstand.jobs.service.JobId;

public class JobIdAdapter implements JsonbAdapter<JobId,String> {

	@Override
	public JobId adaptFromJson(String v) throws Exception {
		return JobId.valueOf(v);
	}

	@Override
	public String adaptToJson(JobId v) throws Exception {
		return JobId.toString(v);
	}



}
