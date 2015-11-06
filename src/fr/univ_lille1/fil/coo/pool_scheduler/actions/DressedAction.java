package fr.univ_lille1.fil.coo.pool_scheduler.actions;

public class DressedAction extends ScenarioAction {
/**
 * Action about dressing someone
 *
 */

	/**
	 * Action to dress clothes
	 * @param timeToEnd time to totally dress clothes
	 */
	public DressedAction(int timeToEnd) {
		super(timeToEnd, "Dressing");
	}
}
