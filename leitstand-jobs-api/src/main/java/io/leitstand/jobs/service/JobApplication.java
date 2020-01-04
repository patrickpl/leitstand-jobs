/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.leitstand.commons.model.Scalar;
import io.leitstand.jobs.jsonb.JobApplicationAdapter;

@JsonbTypeAdapter(JobApplicationAdapter.class)
public class JobApplication extends Scalar<String>{

	private static final long serialVersionUID = 1L;

	public static JobApplication valueOf(String application) {
		return Scalar.fromString(application,JobApplication::new);
	}
	
	@NotNull(message="{job_application.required}")
	@Pattern(message="{job_application.invalid}", regexp="\\p{Print}{1,64}")

	private String value;
	
	public JobApplication(String value){
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}

}