/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import io.leitstand.jobs.service.TaskType;

@Converter
public class TaskTypeConverter implements AttributeConverter<TaskType, String> {

	@Override
	public String convertToDatabaseColumn(TaskType id) {
		return TaskType.toString(id);
	}

	@Override
	public TaskType convertToEntityAttribute(String s) {
		return TaskType.valueOf(s);
	}

}
