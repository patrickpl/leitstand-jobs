/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import java.util.UUID;

import javax.json.bind.annotation.JsonbTypeAdapter;

import io.leitstand.commons.model.Scalar;
import io.leitstand.jobs.jsonb.JobIdAdapter;

@JsonbTypeAdapter(JobIdAdapter.class)
public class JobId extends Scalar<String> {

	private static final long serialVersionUID = 1L;

	public static final JobId randomJobId(){
		return new JobId(UUID.randomUUID().toString());
	}

	/**
	 * Creates an <code>JobId</code> from the specified string.
	 * @param id the job ID
	 * @return the <code>JobId</code> or <code>null</code> if the specified string is <code>null</code> or empty.
	 */
	public static JobId valueOf(String id) {
		return fromString(id,JobId::new);
	}
	
	private String value;
	
	public JobId(){
		// JPA
	}
	
	public JobId(String value){
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}

}
