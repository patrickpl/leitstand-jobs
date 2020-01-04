/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import java.util.HashSet;
import java.util.Set;

public class JobGraph  {

	private Job flow;
	private Set<Job_Task_Transition> edges;
	private Set<Job_Task> nodes;
	
	public JobGraph(Job flow){
		this.flow = flow;
		this.edges = new HashSet<>();
		this.nodes = new HashSet<>();
	}
	
	public void accept(JobGraphVisitor visitor){
		Job_Task start = flow.getStart();
		traverse(visitor,start);
	}
	
	private void traverse(JobGraphVisitor visitor, Job_Task task){
		if(nodes.add(task)) {
			visitor.visitNode(task);
		}
		for(Job_Task_Transition transition : task.getSuccessors()){
			traverse(visitor,transition.getTo());
			if(edges.add(transition)){
				visitor.visitEdge(transition);
			}
		}
	}
}