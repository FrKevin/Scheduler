package fr.univ_lille1.fil.coo.pool_scheduler.actions;

public class ForeseableAction  extends Action{
	protected int timeToEnd;
	protected int time;
	
	/**
	 * Init ForeseableAction
	 * @param timeToEnd the time for execute action
	 * throw new IllegalArgumentException if timeToEnd = 0
	 */
	public ForeseableAction(int timeToEnd){
		if(timeToEnd == 0){
			throw new IllegalArgumentException("Can't add an already finished action");
		}
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
		if(!isFinished()){
			time++;
		}
	}

	public int getTimeToEnd() {
		return timeToEnd;
	}

	public int getTime() {
		return time;
	}
	
	@Override
	public String toString() {
		// TODO Stub de la méthode généré automatiquement
		return "Time : " + time + " TimeEnd : " + timeToEnd;
	}
	
}
