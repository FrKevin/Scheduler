package fr.univ_lille1.fil.coo.pool_scheduler.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ResourcePool<T extends Resource> {

	protected List<T> resources = new ArrayList<>();
	protected List<T> usedResources = new ArrayList<>();
	
	public Resource provideRessource(T r){
		int index = resources.indexOf(r);
		if(index > -1 ){
			return resources.get(index);
		}
		else {
			if(usedResources.contains(r)) {
				throw new NoSuchElementException("This ressource is used");
			}
			throw new IllegalArgumentException("This ressource not exist");
		}
	}
	
	public void freeRessource(T r){
		int index = resources.indexOf(r);
		if(index > -1 ){
			usedResources.add(resources.get(index));
			resources.remove(index);
		}
		else{
			throw new IllegalArgumentException("This re");
		}
	}
	
	public void addResource(T r){
		resources.add(r);
	}
	
	public int getNTotalResource() {
		return getNAvailableResource() + getNUsedResource();
	}
	
	public int getNAvailableResource() {
		return resources.size();
	}
	
	public int getNUsedResource() {
		return usedResources.size();
	}
}
