/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.leitstand.commons.model.Scalar;
import io.leitstand.jobs.jsonb.JobNameAdapter;

@JsonbTypeAdapter(JobNameAdapter.class)
public class JobName extends Scalar<String>{

	private static final long serialVersionUID = 1L;

	public static JobName valueOf(Scalar<String> name) {
		return valueOf(name.toString());
	}
	
	public static JobName valueOf(String name) {
		return Scalar.fromString(name,JobName::new);
	}
	
	@NotNull(message="{job_name.required}")
	@Pattern(message="{job_name.invalid}", regexp="\\p{Print}{1,64}")
	private String value;
	
	public JobName(String value){
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}

}