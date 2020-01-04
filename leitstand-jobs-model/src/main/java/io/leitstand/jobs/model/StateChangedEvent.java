/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

public interface StateChangedEvent {

	
	boolean isCompleted();
	boolean isCancelled();
	boolean isFailed();
	boolean isTimedOut();
	boolean isRejected();
	boolean isActive();
	boolean isReady();
	
}
