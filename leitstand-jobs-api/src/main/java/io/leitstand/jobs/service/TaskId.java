/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import java.util.UUID;

import javax.json.bind.annotation.JsonbTypeAdapter;

import io.leitstand.commons.model.Scalar;
import io.leitstand.jobs.jsonb.TaskIdAdapter;

@JsonbTypeAdapter(TaskIdAdapter.class)
public class TaskId extends Scalar<String> {

	private static final long serialVersionUID = 1L;

	public static final TaskId randomTaskId(){
		return new TaskId(UUID.randomUUID().toString());
	}
	
	/**
	 * Creates a <code>TaskId</code> from the specified string.
	 * @param id the task ID
	 * @return the <code>TaskId</code> or <code>null</code> if the specified string is <code>null</code> or empty.
	 */
	public static TaskId valueOf(String id) {
		return fromString(id,TaskId::new);
	}
	
	private String value;
	
	public TaskId(){
		// JAXB
	}
	
	public TaskId(String value){
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}

}
