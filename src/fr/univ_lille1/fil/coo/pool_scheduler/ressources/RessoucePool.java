package fr.univ_lille1.fil.coo.pool_scheduler.ressources;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class RessoucePool<T extends Ressource> {
	public int numberRessources;
	public ArrayList<T> ressources = new ArrayList<>();
	public ArrayList<T> usedRessources = new ArrayList<>();
	
	public Ressource provideRessource(Ressource r){
		int index = ressources.indexOf(r);
		if(index > -1 ){
			return ressources.get(index);
		}
		else{
			throw new NoSuchElementException("You can't add action on finished scheduler");
		}
	}
	
	public void freeRessource(Ressource r){
		int index = ressources.indexOf(r);
		if(index > -1 ){
			usedRessources.add(ressources.get(index));
			ressources.remove(index);
		}
		else{
			throw new IllegalArgumentException("You can't add action on finished scheduler");
		}
	}
}
