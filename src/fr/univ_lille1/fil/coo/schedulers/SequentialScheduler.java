package fr.univ_lille1.fil.coo.schedulers;

import java.util.List;

import fr.univ_lille1.fil.coo.actions.Action;

public class SequentialScheduler extends Scheduler {
	
	
	
	public SequentialScheduler(List<Action> actions) {
		super(actions);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void nextAction() {

		if(actions.size() > 0 && actions.get(0).isFinished()){
			remove();
		}
		if(actions.size() > 0){
			actions.get(0).doStep();
		}

	}

	@Override
	public void doStep() {
		nextAction();
	}

	@Override
	public void remove() {
		actions.remove(0);	
	}

}
