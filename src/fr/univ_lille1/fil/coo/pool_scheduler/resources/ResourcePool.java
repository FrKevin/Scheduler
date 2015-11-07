package fr.univ_lille1.fil.coo.pool_scheduler.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ResourcePool<T extends Resource> {
	
	/**
	 * The general ressource for pool
	 */
	protected List<T> resources = new ArrayList<>();
	
	/**
	 * The used ressource
	 */
	protected List<T> usedResources = new ArrayList<>();
	
	/**
	 * The capacity of pool
	 */
	protected int capacity;
	
	public ResourcePool(int capacity){
		this.capacity = capacity;
	}
	
	public T provideRessource(T r){
		int index = resources.indexOf(r);
		if(index > -1 && !usedResources.contains(r)){
			usedResources.add(resources.get(index));
			return resources.get(index);
		}
		else {

			if(usedResources.contains(r)) {
				throw new NoSuchElementException("This ressource is used");
			}
			throw new IllegalArgumentException("This ressource doesn't exist");

		}
	}
	
	public void freeRessource(T r){
		int index = usedResources.indexOf(r);
		if(index > -1 ){
			usedResources.remove(index);
			System.out.println("This ressource is unlocked.");
		}
		else{
			System.out.println("This ressource is not used.");
		}
	}
	
	public void addResource(T r){
		if(resources.size() < capacity) {
			resources.add(r);
		}
		else{
			throw new ArrayIndexOutOfBoundsException("max capacity for ResourcePool");
		}
	}
	
	public T getFirstRessource(){
		if(resources.size() > 0 )
			return resources.get(0);
		return null;
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

	public int getCapacity() {
		return capacity;
	}

	public List<T> getResources() {
		return resources;
	}

	public List<T> getUsedResources() {
		return usedResources;
	}
	
}