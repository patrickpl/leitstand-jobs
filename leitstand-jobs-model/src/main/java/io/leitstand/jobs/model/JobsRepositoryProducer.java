/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.TransactionScoped;

import io.leitstand.commons.model.Repository;

@Dependent
public class JobsRepositoryProducer {

	@PersistenceUnit(unitName="jobs")
	private EntityManagerFactory emf;
	
	@Produces
	@TransactionScoped
	@Jobs
	public Repository createSchedulerRepository() {
		return new Repository(emf.createEntityManager());
	}
	
	public void closeRepository(@Disposes @Jobs Repository repository) {
		repository.close();
	}
	
}
