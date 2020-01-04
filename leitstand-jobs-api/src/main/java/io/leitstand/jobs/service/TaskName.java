/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import javax.json.bind.annotation.JsonbTypeAdapter;

import io.leitstand.commons.model.Scalar;
import io.leitstand.jobs.jsonb.TaskNameAdapter;

@JsonbTypeAdapter(TaskNameAdapter.class)
public class TaskName extends Scalar<String> {

	private static final long serialVersionUID = 1L;

	public static TaskName valueOf(Scalar<String> name) {
		return Scalar.fromString(name.getValue(),TaskName::new);
	}
	
	public static TaskName valueOf(String name) {
		return Scalar.fromString(name,TaskName::new);
	}
	
	private String value;
	
	public TaskName(String value) {
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}

}
