/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import static io.leitstand.commons.model.BuilderUtil.assertNotInvalidated;


public class JobFlow extends BaseJobEnvelope {

	public static Builder newJobFlow() {
		return new Builder();
	}
	
	public static class Builder extends BaseJobEnvelopeBuilder<JobFlow, Builder>{
		
		public Builder() {
			super(new JobFlow());
		}
		
		public Builder withGraph(String flow) {
			assertNotInvalidated(getClass(), object);
			object.graph = flow;
			return this;
		}
	}
	
	private String graph;

	public String getGraph() {
		return graph;
	}

}