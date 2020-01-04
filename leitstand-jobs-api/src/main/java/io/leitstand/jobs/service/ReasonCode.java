/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.service;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.ResourceBundle;

import io.leitstand.commons.Reason;

public enum ReasonCode implements Reason{

	JOB0100E_JOB_NOT_FOUND,
	JOB0101I_JOB_SETTINGS_UPDATED,
	JOB0102E_JOB_SETTINGS_IMMUTABLE, 
	JOB0103I_JOB_CONFIRMED,
	JOB0104I_JOB_CANCELLED,
	JOB0105I_JOB_RESUMED,
	JOB0106E_CANNOT_CANCEL_COMPLETED_JOB,
	JOB0107I_JOB_STORED,
	JOB0108I_JOB_REMOVED,
	JOB0109E_CANNOT_COMMIT_COMPLETED_JOB,
	JOB0110E_CANNOT_RESUME_COMPLETED_JOB,
	JOB0200E_TASK_NOT_FOUND,
	JOB0201E_CANNOT_MODIFY_COMPLETED_TASK,
	JOB0202I_TASK_STATE_UPDATED, 
	JOB0111E_JOB_NOT_REMOVABLE,
	JOB0112I_JOB_REMOVED;

	private static final ResourceBundle MESSAGES = ResourceBundle.getBundle("JobMessages");
	
	/**
	 * {@inheritDoc}
	 */
	public String getMessage(Object... args){
		try{
			String pattern = MESSAGES.getString(name());
			return MessageFormat.format(pattern, args);
		} catch(Exception e){
			return name() + Arrays.asList(args);
		}
	}
	
}
