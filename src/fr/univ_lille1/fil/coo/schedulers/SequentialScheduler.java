package fr.univ_lille1.fil.coo.schedulers;

import java.util.List;

import fr.univ_lille1.fil.coo.actions.Action;

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

	@Override
	public boolean isReady() {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}

	@Override
	public boolean isInProgress() {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}

	@Override
	public boolean isFinished() {
		// TODO Stub de la méthode généré automatiquement
		return false;
	}

}
