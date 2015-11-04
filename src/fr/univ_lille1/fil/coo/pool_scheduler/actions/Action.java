package fr.univ_lille1.fil.coo.pool_scheduler.actions;

public abstract class Action {
	
	public abstract boolean  isReady();
	public abstract boolean isInProgress();
	public abstract boolean isFinished();
	public abstract void doStep();
}
