package fr.univ_lille1.fil.coo.pool_scheduler;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.BasketPool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.CubiclePool;

/* Herite certainement de ResourcefulUser */ 
public class Swimmer {

	protected String name;
	protected BasketPool basketPool;
	protected CubiclePool cubiclePool;
	protected int timeForUndress;
	protected int timeForSwim;
	protected int timeForDress;
	
	public Swimmer(String name, BasketPool basketPool, CubiclePool cubiclePool, int timeForUndress, int timeForSwim,
			int timeForDress) {
		this.name = name;
		this.basketPool = basketPool;
		this.cubiclePool = cubiclePool;
		this.timeForUndress = timeForUndress;
		this.timeForSwim = timeForSwim;
		this.timeForDress = timeForDress;
	}
	
	

}
