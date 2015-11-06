package fr.univ_lille1.fil.coo.pool_scheduler.actions;

public class SwimAction extends ForeseableAction {

	public SwimAction(int timeToEnd) {
		super(timeToEnd);
	}
	
	@Override
	public void doStep() {
		super.doStep();
		System.out.println("Swiming ("+time+"/"+timeToEnd+")");
	}
}
