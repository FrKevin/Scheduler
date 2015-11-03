package fr.univ_lille1.fil.coo.main;

import fr.univ_lille1.fil.coo.actions.ForeseableAction;

public class Main {

	public static void main(String[] args) {
		ForeseableAction action = new ForeseableAction(2);
		System.out.println("Begin");
		System.out.println(action.isReady());
		System.out.println(action.isInProgress());
		System.out.println(action.isFinished());
		
		System.out.println("\n1ert step");
		action.doStep();
		
		System.out.println(action.isReady());
		System.out.println(action.isInProgress());
		System.out.println(action.isFinished());
		
		System.out.println("\n2e step");
		action.doStep();
		
		System.out.println(action.isReady());
		System.out.println(action.isInProgress());
		System.out.println(action.isFinished());
	}

}
