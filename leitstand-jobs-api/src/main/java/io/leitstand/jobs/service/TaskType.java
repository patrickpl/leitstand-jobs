/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import javax.json.bind.annotation.JsonbTypeAdapter;

import io.leitstand.commons.model.Scalar;
import io.leitstand.jobs.jsonb.TaskTypeAdapter;

@JsonbTypeAdapter(TaskTypeAdapter.class)
public class TaskType extends Scalar<String> {

	private static final long serialVersionUID = 1L;

	public static TaskType valueOf(String type) {
		return Scalar.fromString(type,TaskType::new);
	}
	
	private String value;
	
	public TaskType(String value) {
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}

}
