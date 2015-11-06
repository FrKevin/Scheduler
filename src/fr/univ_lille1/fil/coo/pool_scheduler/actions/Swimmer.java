package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Basket;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.BasketPool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.CubiclePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.cubicles.Cubicle;
import fr.univ_lille1.fil.coo.pool_scheduler.schedulers.Scenario;

public class Swimmer extends Action {

	protected String name;
	
	protected BasketPool basketPool;
	protected CubiclePool cubiclePool;
	
	protected int timeForUndress;
	protected int timeForSwim;
	protected int timeForDress;
	
	protected ResourcefulUser<Cubicle> userCubicle;
	protected ResourcefulUser<Basket> userBasket;
		
	protected Scenario scenario;
	
	public Swimmer(String name, BasketPool basketPool, CubiclePool cubiclePool, int timeForUndress, int timeForSwim, int timeForDress, 
			       Scenario scenario) {
		this.name = name;
		this.basketPool = basketPool;
		this.cubiclePool = cubiclePool;
		this.timeForUndress = timeForUndress;
		this.timeForSwim = timeForSwim;
		this.timeForDress = timeForDress;
		this.scenario = scenario;
		
	}
	
	public Swimmer(String name, BasketPool basketPool, CubiclePool cubiclePool, int timeForUndress, int timeForSwim, int timeForDress) {
		this(name, basketPool, cubiclePool, timeForUndress, timeForSwim, timeForDress, null);
		this.scenario = createScenario();
	}
	
	
	protected Scenario createScenario(){
		Scenario resultScenario = new Scenario();
		resultScenario.addAction(new TakeResourceAction<>(userBasket, basketPool));
		resultScenario.addAction(new TakeResourceAction<>(userCubicle, cubiclePool));
		resultScenario.addAction(new UnDressedAction(timeForUndress));
		resultScenario.addAction(new FreeResourceAction<>(userCubicle, cubiclePool));
		resultScenario.addAction(new SwimAction(timeForSwim));
		resultScenario.addAction(new TakeResourceAction<Cubicle>(userCubicle, cubiclePool));
		resultScenario.addAction(new DressedAction(timeForDress));
		resultScenario.addAction(new FreeResourceAction<>(userCubicle, cubiclePool));
		resultScenario.addAction(new FreeResourceAction<>(userBasket, basketPool));
		return resultScenario;
	}
	
	
	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	@Override
	public boolean isReady() {
		return scenario.isReady();
	}

	@Override
	public boolean isInProgress() {
		return scenario.isInProgress();
	}

	@Override
	public boolean isFinished() {
		return scenario.isFinished();
	}
	
	@Override
	public void doStep() {
		scenario.doStep();
	}
}
