package fr.univ_lille1.fil.coo.scheduler;

import java.util.Collection;

public abstract class Scheduler extends Action{
	protected Collection<Action> actions;
	
	public void AddAction(Action a){
		actions.add(a);
	}
	
	public abstract void nextAction();
}
