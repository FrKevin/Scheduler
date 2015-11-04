package fr.univ_lille1.fil.coo.pool_scheduler.resources;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class ResourcePool<T extends Resource> {

	public int numberResources;
	public ArrayList<T> resources = new ArrayList<>();
	public ArrayList<T> usedResources = new ArrayList<>();
	
	public Resource provideRessource(Resource r){

		int index = resources.indexOf(r);
		if(index > -1 ){
			return resources.get(index);
		}
		else{
			throw new NoSuchElementException("You can't add action on finished scheduler");
		}
	}
	
	public void freeRessource(Resource r){
		int index = resources.indexOf(r);
		if(index > -1 ){
			usedResources.add(resources.get(index));
			resources.remove(index);
		}
		else{
			throw new IllegalArgumentException("You can't add action on finished scheduler");
		}
	}
}