package fr.univ_lille1.fil.coo.pool_scheduler.actions;

public abstract class ScenarioAction extends ForeseableAction {
	
	protected String message;
	
	/**
	 * Init an action with a message to describe it
	 * @param timeToEnd the time like {@link ForeseableAction}
	 * @param message The message which describes the action
	 */
	public ScenarioAction(int timeToEnd, String message) {
		super(timeToEnd);
		this.message = message;
	}
		
	@Override
	public void doStep() {
		super.doStep();
		System.out.println(message +" ("+time+"/"+timeToEnd+")");
	}
}
