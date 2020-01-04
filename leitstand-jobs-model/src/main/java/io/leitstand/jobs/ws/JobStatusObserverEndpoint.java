/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.ws;

import static javax.json.Json.createObjectBuilder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import io.leitstand.inventory.service.ElementSettings;
import io.leitstand.jobs.model.InventoryClient;
import io.leitstand.jobs.model.Job;
import io.leitstand.jobs.model.Job_Task;
import io.leitstand.jobs.model.TaskStateChangedEvent;
//TODO POLISH
@ApplicationScoped
@ServerEndpoint("/ws/subscribe/{job_id}")
public class JobStatusObserverEndpoint {

	private ConcurrentMap<String,Session> sessions = new ConcurrentHashMap<>();

	@Inject
	private InventoryClient inventory;
	
	@OnOpen
	public void subscribe(Session session, @PathParam("job_id") String jobId){
		session.getUserProperties().put("job_id", jobId);
		sessions.put(jobId,session);
	}
	
	@OnClose
	public void unsubscribe(@PathParam("job_id") String jobId){
		sessions.remove(jobId);
	}
	
	
	public void notifyBrowser(@Observes TaskStateChangedEvent event){
		Job_Task task = event.getTask();
		if(task.isElementTask()){
			Job flow = task.getJob();
			String jobId = flow.getJobId().toString();
			Session session = sessions.get(jobId);
			if(session != null && session.isOpen()){
				try{
					ElementSettings element = inventory.getElementSettings(task);
					String message = createObjectBuilder()
									 .add("element_id", element.getElementId().toString())
									 .add("task_state", element.getElementName().toString())
									 .build()
									 .toString();
					Async remote = session.getAsyncRemote();
					remote.sendText(message);
					
				} catch (Exception e){
					// Ignore
				}
			} else {
				sessions.remove(jobId);
			}
		}

	}
	
}
