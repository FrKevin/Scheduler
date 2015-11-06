package fr.univ_lille1.fil.coo.pool_scheduler.actions;

public class DressedAction extends ForeseableAction{

	public DressedAction(int timeToEnd) {
		super(timeToEnd);
	}

	@Override
	public void doStep() {
		super.doStep();
		System.out.println("dressing ("+time+"/"+timeToEnd+")");
	}
}
