package fr.univ_lille1.fil.coo.pool_scheduler.actions;

/**
 * Class representing the udressing action
 *
 */
public class UnDressedAction extends ScenarioAction{
	
	/**
	 * Action to undress clothes
	 * @param timeToEnd time to totally remove clothes
	 */
	public UnDressedAction(int timeToEnd) {
		super(timeToEnd, "Undressing");
	}
}
