/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static io.leitstand.commons.etc.FileProcessor.yaml;
import static io.leitstand.jobs.service.TaskState.ACTIVE;
import static io.leitstand.jobs.service.TaskState.COMPLETED;
import static io.leitstand.jobs.service.TaskState.FAILED;
import static io.leitstand.jobs.service.TaskState.REJECTED;

import java.io.IOException;
import java.io.StringReader;

import javax.ws.rs.core.Response;

import io.leitstand.commons.http.GenericRestClient;
import io.leitstand.commons.http.JsonRequest;
import io.leitstand.jobs.service.TaskState;

public class InvokeRestApiTaskProcessor implements TaskProcessor {
	
	private GenericRestClient client;
	
	public InvokeRestApiTaskProcessor(GenericRestClient client) {
		this.client = client;
	}
	
	public TaskState execute(Job_Task task) {
		try {
			JsonRequest request  = adaptFromJsonJsonRequest(task);
			Response 	response = client.invoke(request);
			return mapStatusToTaskState(response);
		} catch(Exception e) {
			return FAILED;
		}
	}

	private JsonRequest adaptFromJsonJsonRequest(Job_Task task) throws IOException {
		return yaml(JsonRequest.class)
			   .process(new StringReader(task.getParameters().toString()));
	}

	protected TaskState mapStatusToTaskState(Response response) {
		switch(response.getStatus()) {
			case 200: //OK
			case 201: //Created
			case 204: //No content
				return COMPLETED;
			case 202: //Accepted
				return ACTIVE;
			case 409: //Conflict
				return REJECTED;
			default:
				return FAILED;
		
		}
	
	}
}
