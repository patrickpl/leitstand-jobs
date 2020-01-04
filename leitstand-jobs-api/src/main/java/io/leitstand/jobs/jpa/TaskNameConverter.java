/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import io.leitstand.jobs.service.TaskName;

@Converter
public class TaskNameConverter implements AttributeConverter<TaskName, String> {

	@Override
	public String convertToDatabaseColumn(TaskName id) {
		return TaskName.toString(id);
	}

	@Override
	public TaskName convertToEntityAttribute(String s) {
		return TaskName.valueOf(s);
	}

}
