/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

public interface JobGraphVisitor {

	void visitNode(Job_Task task);
	void visitEdge(Job_Task_Transition transition);
	
}
