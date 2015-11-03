package fr.univ_lille1.fil.coo.schedulers;

import java.util.List;

import fr.univ_lille1.fil.coo.actions.Action;

public class FairScheduler extends Scheduler {
	
	public int idCurrentAction = 0;

	
	public FairScheduler(List<Action> actions) {
		super(actions);
	}
	
	public FairScheduler() {
		super();
	} 
	
	@Override
	public void nextAction() {
		if(idCurrentAction < actions.size() - 1) {
			idCurrentAction++;
		} 
		else {
			idCurrentAction = 0;
		}
	}
	
	@Override
	public void doStep() {
		setReady(false);
		if(isFinished()) {
			return;
		}
		actions.get(idCurrentAction).doStep();
		if(actions.get(idCurrentAction).isFinished()) {
			remove();
		}
		nextAction();
	}
	
	@Override
	public void remove() {
		actions.remove(idCurrentAction--);	
	}
}
