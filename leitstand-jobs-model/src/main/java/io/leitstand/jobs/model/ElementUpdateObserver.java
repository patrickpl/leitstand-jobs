/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.inventory.service.OperationalState.MAINTENANCE;
import static io.leitstand.inventory.service.OperationalState.OPERATIONAL;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import io.leitstand.inventory.service.ElementService;
import io.leitstand.jobs.service.TaskType;
//TODO Move to update app
//TODO Check for application name
@Dependent
public class ElementUpdateObserver {

	@Inject
	private ElementService inventory;
	
	public void taskUpdate(@Observes TaskStateChangedEvent event){
		Job_Task task = event.getTask();
		if(task.isElementTask()) {
			TaskType type = task.getTaskType();
			if("activate".equals(type.toString())){ // TODO Introduce enum of available tasks!
				if(task.isActive()){
					inventory.updateElementOperationalState(task.getElementId(), MAINTENANCE);
				} else {
					inventory.updateElementOperationalState(task.getElementId(), OPERATIONAL);
				}
			}
		
		}
		
	}
}
