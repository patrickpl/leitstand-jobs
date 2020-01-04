/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class JoinTest {

	private Job_Task a;
	private Job_Task b;
	private Job_Task ab;
	
	@Before
	public void setup_graph(){
		a = new Job_Task();
		b = new Job_Task();
		ab = new Job_Task();
		
	}
	
	@Test
	public void add_join_as_successor_of_given_predecessors(){
		ab.join(a,b);
		assertTrue(a.isPredecessorOf(ab));
		assertTrue(b.isPredecessorOf(ab));
		assertTrue(ab.isSuccessorOf(a));
		assertTrue(ab.isSuccessorOf(b));
		
	}
	
	@Test
	public void remove_join_as_successor_also_removes_predecessor_from_predecessors_list(){
		ab.join(a,b);
		a.removeSuccessor(ab);
		assertFalse(a.isPredecessorOf(ab));
		assertTrue(b.isPredecessorOf(ab));
		assertFalse(ab.isSuccessorOf(a));
		assertTrue(ab.isSuccessorOf(b));
		
	}
	
	
}
