/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jsonb;

import javax.json.bind.adapter.JsonbAdapter;

import io.leitstand.jobs.service.JobName;

public class JobNameAdapter implements JsonbAdapter<JobName,String> {

	@Override
	public JobName adaptFromJson(String v) throws Exception {
		return JobName.valueOf(v);
	}

	@Override
	public String adaptToJson(JobName v) throws Exception {
		return JobName.toString(v);
	}



}
