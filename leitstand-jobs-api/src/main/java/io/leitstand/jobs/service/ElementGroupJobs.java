/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

import io.leitstand.commons.model.ValueObject;
import io.leitstand.inventory.service.ElementGroupId;
import io.leitstand.inventory.service.ElementGroupName;


public class ElementGroupJobs extends ValueObject {

	public static Builder newElementGroupJobs(){
		return new Builder();
	}
	
	public static class Builder {
		
		private ElementGroupJobs jobs = new ElementGroupJobs();
		
		public Builder withGroupId(ElementGroupId groupId){
			jobs.groupId = groupId;
			return this;
		}
		
		public Builder withGroupName(ElementGroupName groupName){
			jobs.groupName = groupName;
			return this;
		}

		public Builder withJobs(List<ElementGroupJobSummary> jobs){
			this.jobs.jobs = unmodifiableList(new ArrayList<>(jobs));
			return this;
		}
		
		public ElementGroupJobs build(){
			try{
				return jobs;
			} finally {
				this.jobs = null;
			}
		}
		
	}
	
	@JsonbProperty("group_id")
	private ElementGroupId groupId;
	
	@JsonbProperty("group_name")
	private ElementGroupName groupName;
	
	private List<ElementGroupJobSummary> jobs;
	
	
	public ElementGroupId getGroupId() {
		return groupId;
	}
	
	public ElementGroupName getGroupName() {
		return groupName;
	}
	
	public List<ElementGroupJobSummary> getJobs() {
		return unmodifiableList(jobs);
	}
	
}
