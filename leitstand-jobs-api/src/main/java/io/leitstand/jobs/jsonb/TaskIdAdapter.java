/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jsonb;

import javax.json.bind.adapter.JsonbAdapter;

import io.leitstand.jobs.service.TaskId;

public class TaskIdAdapter implements JsonbAdapter<TaskId,String> {

	@Override
	public TaskId adaptFromJson(String v) throws Exception {
		return TaskId.valueOf(v);
	}

	@Override
	public String adaptToJson(TaskId v) throws Exception {
		return TaskId.toString(v);
	}

}
