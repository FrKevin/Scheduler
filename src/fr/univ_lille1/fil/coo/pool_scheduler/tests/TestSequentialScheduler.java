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
	public void testAddAction() {
		SequentialScheduler scheduler = new SequentialScheduler();
		scheduler.addAction(new ForeseableAction(2));
		scheduler.addAction(new ForeseableAction(5));
		assertFalse(scheduler.getActions().isEmpty());
		assertTrue(scheduler.getActions().size() == 2);
	}
	
	@Test
	public void testIsReady() {
		SequentialScheduler scheduler = new SequentialScheduler();
		scheduler.addAction(new ForeseableAction(10));
		assertTrue(scheduler.isReady());
		assertFalse(scheduler.isInProgress());
		assertFalse(scheduler.isFinished());
		
	}
	
	
	@Test
	public void testDoStep() {
		SequentialScheduler scheduler = new SequentialScheduler();
		//action 1
		scheduler.addAction(new ForeseableAction(2));
		//action 2
		scheduler.addAction(new ForeseableAction(2));
		
		//action 1
		assertTrue(scheduler.getActions().get(0).isReady());
		assertFalse(scheduler.getActions().get(0).isInProgress());
		assertFalse(scheduler.getActions().get(0).isFinished());
		
		//action 2
		assertTrue(scheduler.getActions().get(1).isReady());
		assertFalse(scheduler.getActions().get(1).isInProgress());
		assertFalse(scheduler.getActions().get(1).isFinished());
		
		scheduler.doStep();
		
		//action 1
		assertFalse(scheduler.getActions().get(0).isReady());
		assertTrue(scheduler.getActions().get(0).isInProgress());
		assertFalse(scheduler.getActions().get(0).isFinished());
		
		//action 2
		assertTrue(scheduler.getActions().get(1).isReady());
		assertFalse(scheduler.getActions().get(1).isInProgress());
		assertFalse(scheduler.getActions().get(1).isFinished());
		
		scheduler.doStep();
		
		//action 2
		assertTrue(scheduler.getActions().get(0).isReady());
		assertFalse(scheduler.getActions().get(0).isInProgress());
		assertFalse(scheduler.getActions().get(0).isFinished());
		

		scheduler.doStep();
		
		//action 2
		assertFalse(scheduler.getActions().get(0).isReady());
		assertTrue(scheduler.getActions().get(0).isInProgress());
		assertFalse(scheduler.getActions().get(0).isFinished());
		
		scheduler.doStep();
		
		assertTrue(scheduler.getActions().isEmpty());
		
	}
	
	@Test
	public void testIsInProgress() {
		SequentialScheduler scheduler = new SequentialScheduler();
		scheduler.addAction(new ForeseableAction(2));
		assertTrue(scheduler.isReady());
		assertFalse(scheduler.isInProgress());
		assertFalse(scheduler.isFinished());
		scheduler.doStep();
		assertFalse(scheduler.isReady());
		assertTrue(scheduler.isInProgress());
		assertFalse(scheduler.isFinished());
	}
	

	@Test
	public void testIsFinished() {
		SequentialScheduler scheduler = new SequentialScheduler();
		scheduler.addAction(new ForeseableAction(2));
		assertTrue(scheduler.isReady());
		assertFalse(scheduler.isInProgress());
		assertFalse(scheduler.isFinished());
		scheduler.doStep();
		assertFalse(scheduler.isReady());
		assertTrue(scheduler.isInProgress());
		assertFalse(scheduler.isFinished());
		scheduler.doStep();
		assertFalse(scheduler.isReady());
		assertFalse(scheduler.isInProgress());
		assertTrue(scheduler.isFinished());
	}

}
