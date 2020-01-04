/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import io.leitstand.jobs.service.TaskId;

@Converter
public class TaskIdConverter implements AttributeConverter<TaskId, String> {

	@Override
	public String convertToDatabaseColumn(TaskId id) {
		return TaskId.toString(id);
	}

	@Override
	public TaskId convertToEntityAttribute(String s) {
		return TaskId.valueOf(s);
	}

}
