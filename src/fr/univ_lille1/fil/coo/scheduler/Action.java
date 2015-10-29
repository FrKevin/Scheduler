package fr.univ_lille1.fil.coo.scheduler;

public abstract class Action {
	
	public abstract boolean  isReady();
	public abstract boolean isInProgress();
	public abstract boolean isFinished();
	public abstract boolean doStep();
}
