package fr.univ_lille1.fil.coo.schedulers;

import java.util.List;

import fr.univ_lille1.fil.coo.actions.Action;

public abstract class Scheduler extends Action {
	
	protected List<Action> actions;
	
	protected boolean isReady = true;
	
	public Scheduler(List<Action> actions) {
		this.actions = actions;
	}
	
	public void addAction(Action a) {
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
