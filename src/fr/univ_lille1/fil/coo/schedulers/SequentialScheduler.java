package fr.univ_lille1.fil.coo.schedulers;

import java.util.List;

import fr.univ_lille1.fil.coo.actions.Action;

public class SequentialScheduler extends Scheduler {
	
	private boolean isReady;
	private int idCurrentAction = 0;
	
	public SequentialScheduler(List<Action> actions) {
		super(actions);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void nextAction() {
		idCurrentAction++;
	}
	
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
	
	@Override
	public void doStep() {
		if(isFinished()) {
			return;
		}
		setReady(false);
		if(actions.get(idCurrentAction).isFinished()) {
			remove();
			nextAction();
		}
		actions.get(idCurrentAction).doStep();
	}

	@Override
	public void remove() {
		actions.remove(idCurrentAction--);	
	}

}
