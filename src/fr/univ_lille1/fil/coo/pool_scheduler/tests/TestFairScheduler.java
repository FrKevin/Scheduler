package fr.univ_lille1.fil.coo.pool_scheduler.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univ_lille1.fil.coo.pool_scheduler.actions.ForeseableAction;
import fr.univ_lille1.fil.coo.pool_scheduler.schedulers.FairScheduler;
import fr.univ_lille1.fil.coo.pool_scheduler.schedulers.Scheduler;

public class TestFairScheduler {
	
	
	Scheduler scheduler;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		scheduler = new FairScheduler();
		scheduler.addAction(new ForeseableAction(2));
		scheduler.addAction(new ForeseableAction(3));
		scheduler.addAction(new ForeseableAction(1));
		scheduler.addAction(new ForeseableAction(4));

	}

	/**
	 * @throws java.lang.Exception
	 */
	
	@After
	public void tearDown() throws Exception {
		scheduler = null;
	}

	@Test
	public void testDoStep() {
		fail("Pas encore implémenté");
	}

	@Test
	public void testNextAction() {
		fail("Pas encore implémenté");
	}

	@Test
	public void testRemove() {
		fail("Pas encore implémenté");
	}

	@Test
	public void testGetCurrentAction() {
		fail("Pas encore implémenté");
	}

}
