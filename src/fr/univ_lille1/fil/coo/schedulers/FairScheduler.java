package fr.univ_lille1.fil.coo.schedulers;

import java.util.List;

import fr.univ_lille1.fil.coo.actions.Action;

public class FairScheduler extends Scheduler{
	private int numberOfRunAction = 0;
	
	public FairScheduler(List<Action> actions) {
		super(actions);
	}

	@Override
	public void nextAction() {
		for(int i=numberOfRunAction; i>=0; i--){
			actions.get(i).doStep();
		}
		if( numberOfRunAction < actions.size()){
			numberOfRunAction++;
		}
	}
	
	@Override
	public void doStep() {
		nextAction();
		remove();
	}
	
	@Override
	public void remove() {
		for(int i=0; i<actions.size(); i++){
			if(actions.get(i).isFinished()){
				actions.remove(i);
				numberOfRunAction--;
			}
		}
	}
}
