package fr.univ_lille1.fil.coo.pool_scheduler.actions;

//Unsed
public class RenderAction extends Action {
	
	protected boolean isReady = true;
	protected String message;
	
	public RenderAction(String message){
		this.message = message;
	}
	
	@Override
	public boolean isReady() {
		return isReady;
	}

	@Override
	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}

	@Override
	public boolean isFinished() {
		return !isReady;
	}

	@Override
	public void doStep() {
		isReady = false;
		System.out.println(message);
	}

}
