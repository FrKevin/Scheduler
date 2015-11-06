package fr.univ_lille1.fil.coo.pool_scheduler.actions;

public class UnDressedAction extends ForeseableAction{

	public UnDressedAction(int timeToEnd) {
		super(timeToEnd);
	}
	
	@Override
	public void doStep() {
		super.doStep();
		System.out.println("Undressing ("+time+"/"+timeToEnd+")");
	}
}
