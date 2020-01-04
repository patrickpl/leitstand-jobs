/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import io.leitstand.jobs.service.JobName;

@Converter
public class JobNameConverter implements AttributeConverter<JobName, String> {

	@Override
	public String convertToDatabaseColumn(JobName id) {
		return JobName.toString(id);
	}

	@Override
	public JobName convertToEntityAttribute(String s) {
		return JobName.valueOf(s);
	}

}
