package fr.univ_lille1.fil.coo.pool_scheduler.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univ_lille1.fil.coo.pool_scheduler.actions.TakeResourceAction;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.Cubicle;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.CubiclePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;

public class TestTakeResourceAction {
	
	protected TakeResourceAction<Cubicle> takeResourceAction;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		CubiclePool cubicles = new CubiclePool(3);
		
		for(int i=0; i<3; i++){
			cubicles.addResource(new Cubicle("cubiclePool "+ i));
		}
		takeResourceAction = new TakeResourceAction<>(new ResourcefulUser<Cubicle>(), cubicles);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		takeResourceAction = null;
	}
	
	@Test
	public void testIsReady() {
		assertTrue(takeResourceAction.isReady());
		assertFalse(takeResourceAction.isInProgress());
		assertFalse(takeResourceAction.isFinished());
		
		takeResourceAction.doStep();
		
		assertFalse(takeResourceAction.isReady());
		assertTrue(takeResourceAction.isInProgress());
		assertFalse(takeResourceAction.isFinished());
		
	}

	@Test
	public void testIsInProgress() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsFinished() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoStep() {
		fail("Not yet implemented");
	}

	@Test
	public void testTakeResourceAction() {
		fail("Not yet implemented");
	}

}
