/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.rs;

import static io.leitstand.commons.model.ObjectUtil.asSet;

import java.util.Set;

import javax.enterprise.context.Dependent;

import io.leitstand.commons.rs.ApiResourceProvider;
import io.leitstand.jobs.jsonb.JobApplicationAdapter;
import io.leitstand.jobs.jsonb.JobIdAdapter;
import io.leitstand.jobs.jsonb.JobNameAdapter;
import io.leitstand.jobs.jsonb.JobTypeAdapter;
import io.leitstand.jobs.jsonb.TaskIdAdapter;
import io.leitstand.jobs.jsonb.TaskNameAdapter;
import io.leitstand.jobs.jsonb.TaskTypeAdapter;

/**
 * Provider of all scheduler module resources.
 */
@Dependent
public class JobResources implements ApiResourceProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Class<?>> getResources() {
		return asSet(JobsResource.class,
					 JobResource.class,
					 JobTaskResource.class,
					 ElementGroupJobResource.class,
					 JobApplicationAdapter.class,
					 JobIdAdapter.class,
					 JobNameAdapter.class,
					 JobTypeAdapter.class,
					 TaskIdAdapter.class,
					 TaskNameAdapter.class,
					 TaskTypeAdapter.class);
	}

}