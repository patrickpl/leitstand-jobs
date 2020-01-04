/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import io.leitstand.inventory.service.ElementGroupId;
import io.leitstand.inventory.service.ElementGroupName;
import io.leitstand.inventory.service.ElementGroupType;

public interface ElementGroupJobService {

	ElementGroupJobs getActiveElementGroupJobs(ElementGroupId id);

	ElementGroupJobs getActiveElementGroupJobs(ElementGroupType groupType,
											   ElementGroupName groupName);
	
}
