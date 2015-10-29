package fr.univ_lille1.fil.coo.scheduler;

public class ForeseableAction  extends Action{
	protected int timeToEnd;
	protected int time;
	
	public ForeseableAction(int timeToEnd){
		this.timeToEnd = timeToEnd;
		time = 0;
	}
	
	@Override
	public boolean isReady() {
		return time == 0;
	}

	@Override
	public boolean isInProgress() {
		return time > 0 && time < timeToEnd;
	}

	@Override
	public boolean isFinished() {
		return time == timeToEnd;
	}

	@Override
	public void doStep() {
		time++;
	}

}
