package fr.univ_lille1.fil.coo.schedulers;

import java.util.ArrayList;
import java.util.List;

import fr.univ_lille1.fil.coo.actions.Action;

public abstract class Scheduler{
	protected List<Action> actions = new ArrayList<>();
	
	public Scheduler(List<Action> actions){
		this.actions = actions;
	}
	
	public void AddAction(Action a){
		actions.add(a);
	}
	
	public abstract void nextAction();
	
	public abstract void doStep();
	
	/**
	 * 	Remove all action finished
	 */
	public abstract void remove();
	
}
