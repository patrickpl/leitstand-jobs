/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.rs;

import static io.leitstand.commons.model.Patterns.UUID_PATTERN;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.leitstand.inventory.service.ElementGroupId;
import io.leitstand.inventory.service.ElementGroupName;
import io.leitstand.inventory.service.ElementGroupType;
import io.leitstand.jobs.service.ElementGroupJobService;
import io.leitstand.jobs.service.ElementGroupJobs;

//TODO Clean responsibility of ElementGroupJobResource and JobResource
@RequestScoped
@Path("/{group_type}s")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ElementGroupJobResource {

	
	@Inject
	private ElementGroupJobService service;

	@GET
	@Path("/{group_id:"+UUID_PATTERN+"}/jobs")
	public ElementGroupJobs getGroupActiveJobs(@Valid @PathParam("group_id") ElementGroupId id){
		return service.getActiveElementGroupJobs(id);
	}
	
	@GET
	@Path("/{group_name}/jobs")
	public ElementGroupJobs getGroupActiveJobs(@Valid @PathParam("group_type") ElementGroupType groupType,
											   @Valid @PathParam("group_name") ElementGroupName groupName){
		return service.getActiveElementGroupJobs(groupType,
												 groupName);
	}
}
