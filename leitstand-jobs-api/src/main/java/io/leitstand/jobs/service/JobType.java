/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.leitstand.commons.model.Scalar;
import io.leitstand.jobs.jsonb.JobTypeAdapter;

@JsonbTypeAdapter(JobTypeAdapter.class)
public class JobType extends Scalar<String>{

	private static final long serialVersionUID = 1L;

	public static JobType valueOf(String type) {
		return Scalar.fromString(type,JobType::new);
	}

	@NotNull(message="{job_type.required}")
	@Pattern(message="{job_type.invalid}", regexp="\\p{Print}{1,64}")
	private String value;
	
	public JobType(String value){
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}

}