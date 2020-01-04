/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jsonb;

import javax.json.bind.adapter.JsonbAdapter;

import io.leitstand.jobs.service.TaskName;

public class TaskNameAdapter implements JsonbAdapter<TaskName,String> {

	@Override
	public TaskName adaptFromJson(String v) throws Exception {
		return TaskName.valueOf(v);
	}

	@Override
	public String adaptToJson(TaskName v) throws Exception {
		return TaskName.toString(v);
	}



}
