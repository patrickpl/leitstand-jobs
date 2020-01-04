/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import io.leitstand.jobs.service.JobApplication;

@Converter
public class JobApplicationConverter implements AttributeConverter<JobApplication, String> {

	@Override
	public String convertToDatabaseColumn(JobApplication id) {
		return JobApplication.toString(id);
	}

	@Override
	public JobApplication convertToEntityAttribute(String s) {
		return JobApplication.valueOf(s);
	}

}
