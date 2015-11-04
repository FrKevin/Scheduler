package fr.univ_lille1.fil.coo.pool_scheduler.schedulers;


import java.util.List;

import fr.univ_lille1.fil.coo.pool_scheduler.actions.Action;

public abstract class Scheduler extends Action {
	
	protected List<Action> actions;
	protected boolean isReady;
		
	/**
	 * Create Scheduler with list 
	 * @param actions 
	 */
	public Scheduler(List<Action> actions) {
		this.actions = actions;
	}
	
	
	/**
	 * Add action
	 * @param a Action
	 */
	public void addAction(Action a){
		if(a.isFinished()) {
			throw new IllegalArgumentException("Can't add an already finished action");
		}
		if(isFinished()) {
			throw new IllegalStateException("You can't add action on finished scheduler");
		}
		actions.add(a);
	}
	

	public abstract void nextAction();
	
	/**
	 * 	Remove all action are finished
	 */
	public abstract void remove();

	
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
		return !isReady() && actions.isEmpty();
	}
	

	
}
