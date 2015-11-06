package fr.univ_lille1.fil.coo.pool_scheduler.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Basket;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.clothing.Clothing;

public class TestBasket {
	
	protected Basket basket;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		basket = new Basket("Basket 1");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		basket = null;
	}
	
	@Test
	public void testDescription() {
		assertEquals("Basket 1", basket.description());
	}

	@Test
	public void testAddClothing() {
		assertTrue(basket.getClothing().isEmpty());
		basket.addClothing(new Clothing() {
			
			@Override
			public String description() {
				return "toto";
			}
		});
		assertTrue(basket.getClothing().size() == 1);
	}

	@Test
	public void testRemoveClothing() {
		assertTrue(basket.getClothing().isEmpty());
		Clothing c = new Clothing() {
			
			@Override
			public String description() {
				return "toto";
			}
		};
		basket.addClothing(c);
		assertTrue(basket.getClothing().size() == 1);
		basket.removeClothing(c);
		assertTrue(basket.getClothing().isEmpty());
	}

}
