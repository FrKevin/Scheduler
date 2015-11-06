package fr.univ_lille1.fil.coo.pool_scheduler;

import fr.univ_lille1.fil.coo.pool_scheduler.actions.ActionFinishedException;
import fr.univ_lille1.fil.coo.pool_scheduler.actions.Swimmer;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.BasketPool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.CubiclePool;
import fr.univ_lille1.fil.coo.pool_scheduler.schedulers.FairScheduler;

//import fr.univ_lille1.fil.coo.pool_scheduler.actions.ForeseableAction;

public class Main {

	public static void main(String[] args) throws ActionFinishedException {
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		FairScheduler s = new FairScheduler();
		s.addAction(new Swimmer("Camille", baskets, cubicles, 6, 4, 8));
		s.addAction(new Swimmer("Lois", baskets, cubicles, 2, 10, 4));
		s.addAction(new Swimmer("Maé", baskets, cubicles, 10, 18, 10));
		s.addAction(new Swimmer("Ange", baskets, cubicles, 3, 7, 5));
		s.addAction(new Swimmer("Louison", baskets, cubicles, 18, 3, 3));
		s.addAction(new Swimmer("Charlie", baskets, cubicles, 3, 6, 10));
		s.addAction(new Swimmer("Alexis", baskets, cubicles, 6, 5, 7));
		int nbSteps = 0;
		while (!s.isFinished()) {
			nbSteps++;
			s.doStep();
		}
		System.out.println("Finished in " + nbSteps + " steps");
	}
	/*
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
	*/
}
