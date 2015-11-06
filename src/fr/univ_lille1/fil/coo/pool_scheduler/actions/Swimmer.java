package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Basket;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.BasketPool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.Cubicle;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.CubiclePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;
import fr.univ_lille1.fil.coo.pool_scheduler.schedulers.ScenarioScheduler;

public class Swimmer extends Action {

	protected String name;
	
	protected BasketPool basketPool;
	protected CubiclePool cubiclePool;
	
	protected int timeForUndress;
	protected int timeForSwim;
	protected int timeForDress;
	
	protected ResourcefulUser<Cubicle> userCubicle;
	protected ResourcefulUser<Basket> userBasket;
		
	protected ScenarioScheduler scenarioScheduler;
	
	
	public Swimmer(String name, BasketPool basketPool, CubiclePool cubiclePool, int timeForUndress, int timeForSwim, int timeForDress) {
		this.name = name;
		this.basketPool = basketPool;
		System.out.println();
		this.cubiclePool = cubiclePool;
		this.timeForUndress = timeForUndress;
		this.timeForSwim = timeForSwim;
		this.timeForDress = timeForDress;
		
		userCubicle = new ResourcefulUser<>();
		userBasket = new ResourcefulUser<>();
		
		this.scenarioScheduler = createScenarioScheduler();
	}
		
	protected ScenarioScheduler createScenarioScheduler(){
		ScenarioScheduler resultscenarioScheduler = new ScenarioScheduler();
		resultscenarioScheduler.addAction(new TakeResourceAction<>(userBasket, basketPool));
		resultscenarioScheduler.addAction(new TakeResourceAction<>(userCubicle, cubiclePool));
		resultscenarioScheduler.addAction(new UnDressedAction(timeForUndress));
		resultscenarioScheduler.addAction(new FreeResourceAction<>(userCubicle, cubiclePool));
		resultscenarioScheduler.addAction(new SwimAction(timeForSwim));
		resultscenarioScheduler.addAction(new TakeResourceAction<Cubicle>(userCubicle, cubiclePool));
		resultscenarioScheduler.addAction(new DressedAction(timeForDress));
		resultscenarioScheduler.addAction(new FreeResourceAction<>(userCubicle, cubiclePool));
		resultscenarioScheduler.addAction(new FreeResourceAction<>(userBasket, basketPool));
		return resultscenarioScheduler;
	}
	
	public void setscenarioScheduler(ScenarioScheduler scenarioScheduler) {
		this.scenarioScheduler = scenarioScheduler;
	}

	@Override
	public boolean isReady() {
		return scenarioScheduler.isReady();
	}

	@Override
	public boolean isInProgress() {
		return scenarioScheduler.isInProgress();
	}

	@Override
	public boolean isFinished() {
		return scenarioScheduler.isFinished();
	}
	
	@Override
	public void doStep() {
		scenarioScheduler.doStep();
	}
}