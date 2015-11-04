package fr.univ_lille1.fil.coo.pool_scheduler.ressources;

import java.util.ArrayList;

public abstract class RessoucePool<T> {
	public int numberRessources;
	public ArrayList<T> ressources = new ArrayList<>();
	public ArrayList<T> usedRessources = new ArrayList<>();
	
	public Ressource provideResspurce(Ressource r){
		return null;
	}
	
	public void freeRessource(Ressource r){
		
	}
}
