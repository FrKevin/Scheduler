package fr.univ_lille1.fil.coo.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univ_lille1.fil.coo.actions.ForeseableAction;

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
	public void testIsInProgress() {
		ForeseableAction action = new ForeseableAction(2);
		action.doStep();
		assertFalse(action.isFinished());
		assertTrue(action.isInProgress());
		assertFalse(action.isReady());
	}

	@Test
	public void testIsFinished() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoStep() {
		fail("Not yet implemented");
	}
}
