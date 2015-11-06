package fr.univ_lille1.fil.coo.pool_scheduler.actions;

/**
 * Action using a message to be described
 *
 */
public abstract class ScenarioAction extends ForeseableAction {
	
	protected String message;
	protected String author;
	/**
	 * Init an action with a message to describe it
	 * @param timeToEnd the time like {@link ForeseableAction}
	 * @param message The message which describes the action
	 */
	public ScenarioAction(int timeToEnd, String author, String message) {
		super(timeToEnd);
		this.author = author;
		this.message = message;
	}
		
	@Override
	public void doStep() {
		super.doStep();
		System.out.println(this.author  +" -- "+ message +" ("+time+"/"+timeToEnd+")");
	}
}
