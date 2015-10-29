package fr.univ_lille1.fil.coo.scheduler;

import java.util.List;

public class SequentialScheduler extends Scheduler{
	
	public SequentialScheduler(List<Action> actions) {
		super(actions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void nextAction() {
		if(actions.size() == 0){
			return;
		}
		if(actions.get(0).isFinished()){
			remove();
		}
	}

	@Override
	public void doStep() {
		nextAction();
		actions.get(0).doStep();
	}

	@Override
	public void remove() {
		actions.remove(0);	
	}

}
