/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.jobs.model.Job.findReadyAndActiveJobsForElementGroup;
import static io.leitstand.jobs.service.ElementGroupJobSummary.newElementGroupJobSummary;
import static io.leitstand.jobs.service.ElementGroupJobs.newElementGroupJobs;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import io.leitstand.commons.model.Repository;
import io.leitstand.commons.model.Service;
import io.leitstand.inventory.service.ElementGroupId;
import io.leitstand.inventory.service.ElementGroupName;
import io.leitstand.inventory.service.ElementGroupSettings;
import io.leitstand.inventory.service.ElementGroupType;
import io.leitstand.jobs.service.ElementGroupJobService;
import io.leitstand.jobs.service.ElementGroupJobSummary;
import io.leitstand.jobs.service.ElementGroupJobs;

@Service
public class DefaultElementGroupJobService implements ElementGroupJobService {
	
	@Inject
	private InventoryClient inventory;
	
	@Inject
	@Jobs
	private Repository repository;
	
	@Override
	public ElementGroupJobs getActiveElementGroupJobs(ElementGroupId id) {
		ElementGroupSettings group = inventory.getGroupSettings(id);
		return getActiveElementGroupJobs(group);
	}

	@Override
	public ElementGroupJobs getActiveElementGroupJobs(ElementGroupType groupType,
													  ElementGroupName groupName) {
		ElementGroupSettings group = inventory.getGroupSettings(groupType,
																groupName);
		return getActiveElementGroupJobs(group);
	}
	
	ElementGroupJobs getActiveElementGroupJobs(ElementGroupSettings group) {
		List<ElementGroupJobSummary> jobs = new LinkedList<>();
		for(Job job : repository.execute(findReadyAndActiveJobsForElementGroup(group.getGroupId()))){
			jobs.add(newElementGroupJobSummary()
					 .withJobId(job.getJobId())
					 .withJobName(job.getJobName())
					 .withJobOwner(job.getJobOwner())
					 .withTaskState(job.getJobState())
					 .withStartDate(job.getDateScheduled())
					 .build());
		}
		
		return newElementGroupJobs()
			   .withGroupId(group.getGroupId())
			   .withGroupName(group.getGroupName())
			   .withJobs(jobs)
			   .build();
		
	}


}