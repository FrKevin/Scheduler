package fr.univ_lille1.fil.coo.schedulers;

import java.util.ArrayList;
import java.util.List;

import fr.univ_lille1.fil.coo.actions.Action;

public abstract class Scheduler extends Action {
	
	protected List<Action> actions;
		
	public Scheduler(List<Action> actions) {
		this.actions = actions;
	}
	
	public Scheduler() {
		this(new ArrayList<>());
	}
	
	public void addAction(Action a){
		actions.add(a);
	}
	

	public abstract void nextAction();
		
	/**
	 * 	Remove all action finished
	 */
	public abstract void remove();
	

	
}
