package fr.univ_lille1.fil.coo.pool_scheduler.schedulers;

import java.util.ArrayList;
import java.util.List;

import fr.univ_lille1.fil.coo.pool_scheduler.actions.Action;

public class SequentialScheduler extends Scheduler {
	
	private int idCurrentAction = 0;
	
	public SequentialScheduler(){
		this(new ArrayList<>());
	}
	
	public SequentialScheduler(List<Action> actions) {
		super(actions);
	}
	
	@Override
	public void nextAction() {
		if(idCurrentAction < actions.size() - 1) {
			idCurrentAction++;
		}
	}

	@Override
	public void doStep() {
		this.isReady = false;
		if(isFinished()) {
			return;
		}
		actions.get(idCurrentAction).doStep();
		if(actions.get(idCurrentAction).isFinished()) {
			remove();
			nextAction();
		}
		
	}

	@Override
	public void remove() {
		actions.remove(idCurrentAction--);	
	}

}
