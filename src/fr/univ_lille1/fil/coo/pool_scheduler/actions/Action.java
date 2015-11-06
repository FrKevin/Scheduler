package fr.univ_lille1.fil.coo.pool_scheduler.actions;

/**
 * Represent the base of all actions 
 *
 */
public abstract class Action {
	/**
	 * @return true if action is ready
	 */
	public abstract boolean  isReady();
	
	/**
	 * @return true if action is in progress
	 */
	public abstract boolean isInProgress();
	
	/**
	 * @return true if action is finished
	 */
	public abstract boolean isFinished();
	
	
	/**
	 * @return execute action of the class
	 */
	public abstract void doStep();
}
