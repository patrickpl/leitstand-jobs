/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import io.leitstand.jobs.service.JobType;

@Converter
public class JobTypeConverter implements AttributeConverter<JobType, String> {

	@Override
	public String convertToDatabaseColumn(JobType id) {
		return JobType.toString(id);
	}

	@Override
	public JobType convertToEntityAttribute(String s) {
		return JobType.valueOf(s);
	}

}
