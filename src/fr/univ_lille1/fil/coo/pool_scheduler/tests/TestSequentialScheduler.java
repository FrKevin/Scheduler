package fr.univ_lille1.fil.coo.pool_scheduler.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import fr.univ_lille1.fil.coo.pool_scheduler.actions.Action;
import fr.univ_lille1.fil.coo.pool_scheduler.actions.ForeseableAction;
import fr.univ_lille1.fil.coo.pool_scheduler.schedulers.SequentialScheduler;

public class TestSequentialScheduler {
	
	@Test
	public void testSequentialScheduler() {
		SequentialScheduler scheduler = new SequentialScheduler();
		assertTrue(scheduler.getActions().isEmpty());
	}
	
	@Test
	public void testIsReady() {
		SequentialScheduler scheduler = new SequentialScheduler();
		assertTrue(scheduler.isReady());
		assertFalse(scheduler.isInProgress());
		assertFalse(scheduler.isFinished());
	}
	
	@Test
	public void testDoStep() {
		fail("Not yet implemented");
	}
	
	@Test(expected = IllegalArgumentException.class)  
	public void testAddActionIllegalArgumentException() {
		Action action = new ForeseableAction(2);
		action.doStep();
		action.doStep();
		SequentialScheduler scheduler = new SequentialScheduler();
		scheduler.addAction(action);
	}
	
	@Test(expected = IllegalStateException.class)  
	public void testAddActionIllegalStateException() {
		SequentialScheduler scheduler = new SequentialScheduler();
		scheduler.doStep();
		scheduler.addAction(new ForeseableAction(2));
	}

	
	@Test
	public void testIsInProgress() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testNextAction() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}


	@Test
	public void testIsFinished() {
		fail("Not yet implemented");
	}

}
