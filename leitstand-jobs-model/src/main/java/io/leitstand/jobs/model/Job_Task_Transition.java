/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="job", name="job_task_transition")
@IdClass(Job_Task_TransitionPK.class)
public class Job_Task_Transition implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="from_task_id", nullable=false)
	private Job_Task from;
	
	@Id
	@ManyToOne
	@JoinColumn(name="to_task_id", nullable=false)
	private Job_Task to;
	
	private String name;
	
	protected Job_Task_Transition(){
		//JPA
	}
	
	public Job_Task_Transition(Job_Task from, Job_Task to){
		this.from = from;
		this.to = to;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Job_Task getFrom() {
		return from;
	}
	
	public Job_Task getTo() {
		return to;
	}
	
}
