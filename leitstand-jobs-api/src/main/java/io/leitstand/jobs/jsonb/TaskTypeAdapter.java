/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jsonb;

import javax.json.bind.adapter.JsonbAdapter;

import io.leitstand.jobs.service.TaskType;

public class TaskTypeAdapter implements JsonbAdapter<TaskType,String> {

	@Override
	public TaskType adaptFromJson(String v) throws Exception {
		return TaskType.valueOf(v);
	}

	@Override
	public String adaptToJson(TaskType v) throws Exception {
		return TaskType.toString(v);
	}



}
