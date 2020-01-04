/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import io.leitstand.jobs.service.JobId;

@Converter
public class JobIdConverter implements AttributeConverter<JobId, String> {

	@Override
	public String convertToDatabaseColumn(JobId id) {
		return JobId.toString(id);
	}

	@Override
	public JobId convertToEntityAttribute(String s) {
		return JobId.valueOf(s);
	}

}
