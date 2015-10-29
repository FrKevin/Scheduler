package fr.univ_lille1.fil.coo.scheduler;

import java.util.ArrayList;
import java.util.List;

public abstract class Scheduler{
	protected List<Action> actions = new ArrayList<>();
	
	public Scheduler(List<Action> actions){
		this.actions = actions;
	}
	
	public void AddAction(Action a){
		actions.add(a);
	}
	
	public abstract void nextAction();
	
	/**
	 * 	Execute action
	 */
	public abstract void doStep();
	
	/**
	 * 	Remove all action finished
	 */
	public abstract void remove();
	
}
