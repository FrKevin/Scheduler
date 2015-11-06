package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import java.util.List;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Basket;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.BasketPool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.CubiclePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.cubicles.Cubicle;

public class Swimmer extends Action {

	protected String name;
	
	protected BasketPool basketPool;
	protected CubiclePool cubiclePool;
	
	protected int timeForUndress;
	protected int timeForSwim;
	protected int timeForDress;
	
	protected ResourcefulUser<Cubicle> userCubicle;
	protected ResourcefulUser<Basket> userBasket;
	
	protected boolean isReady = true;
	
	protected List<Action> scenarios;
	
	public Swimmer(String name, BasketPool basketPool, CubiclePool cubiclePool, int timeForUndress, int timeForSwim, int timeForDress) {
		this.name = name;
		this.basketPool = basketPool;
		this.cubiclePool = cubiclePool;
		this.timeForUndress = timeForUndress;
		this.timeForSwim = timeForSwim;
		this.timeForDress = timeForDress;
		
		initScenarios();
	}
			
	private void initScenarios(){
		scenarios.add(new TakeResourceAction<Basket>(userBasket, basketPool));
		scenarios.add(new TakeResourceAction<Cubicle>(userCubicle, cubiclePool));
		
		scenarios.add(new UnDressedAction(timeForUndress));
		scenarios.add(new FreeResourceAction<>(userCubicle, cubiclePool));
		scenarios.add(new SwimAction(timeForSwim));
	}
	
	@Override
	public boolean isReady() {
		return isReady;
	}

	@Override
	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}

	@Override
	public boolean isFinished() {
		return !isReady() && scenarios.isEmpty();
	}
	
	@Override
	public void doStep() {
		isReady = false;
		
	}
}
