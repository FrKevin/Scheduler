package fr.univ_lille1.fil.coo.pool_scheduler.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univ_lille1.fil.coo.pool_scheduler.actions.ForeseableAction;

public class TestForeseableAction {
	
	@Test
	public void testForeseableAction() {
		ForeseableAction action = new ForeseableAction(2);
		assertTrue(action.getTime() == 0);
		assertTrue(action.getTimeToEnd() == 2);
	}
	
	@Test
	public void testIsReady() {
		ForeseableAction action = new ForeseableAction(2);
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
	}
	
	@Test
	public void testDoStep() {
		ForeseableAction action = new ForeseableAction(2);
		action.doStep();
		assertFalse(action.isFinished());
		assertTrue(action.isInProgress());
		assertFalse(action.isReady());
		action.doStep();
		assertTrue(action.isFinished());
		assertFalse(action.isInProgress());
		assertFalse(action.isReady());
	}
	
	@Test
	public void testIsInProgress() {
		ForeseableAction action = new ForeseableAction(2);
		action.doStep();
		assertFalse(action.isFinished());
		assertTrue(action.isInProgress());
		assertFalse(action.isReady());
	}

	@Test
	public void testIsFinished() {
		ForeseableAction action = new ForeseableAction(2);
		action.doStep();
		action.doStep();
		assertTrue(action.isFinished());
		assertFalse(action.isInProgress());
		assertFalse(action.isReady());
	}

}
