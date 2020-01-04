/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

public enum TaskState {
	NEW(false),
	READY(false),
	ACTIVE(false),
	FAILED(true),
	CANCELLED(true),
	SKIPPED(true),
	CONFIRM(false),
	COMPLETED(true),
	TIMEOUT(false),
	REJECTED(true);
	
	private TaskState(boolean terminal){
		this.terminal = terminal;
	}
	
	private boolean terminal;
	
	public boolean isTerminalState(){
		return terminal;
	}
	
}
