package fr.univ_lille1.fil.coo.schedulers;

import java.util.ArrayList;
import java.util.List;

import fr.univ_lille1.fil.coo.actions.Action;

public abstract class Scheduler extends Action {
	
	protected List<Action> actions;
	private boolean isReady;
		
	public Scheduler(List<Action> actions) {
		this.actions = actions;
	}
	
	public Scheduler() {
		this(new ArrayList<>());
	}
	
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
	 * 	Remove all action finished
	 */
	public abstract void remove();
	
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	
	@Override
	public boolean isReady() {
		// TODO Stub de la méthode généré automatiquement
		return isReady;
	}

	@Override
	public boolean isInProgress() {
		// TODO Stub de la méthode généré automatiquement
		return !isReady() && !isFinished();
	}

	@Override
	public boolean isFinished() {
		// TODO Stub de la méthode généré automatiquement
		return !isReady() && actions.isEmpty();
	}
	

	
}
