package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Resource;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;

/**
 * Class to free a ressource to a user
 *
 * @param <R> type of ressource to manage
 */
public class FreeResourceAction<R extends Resource> extends ResourceAction<R>{
	
	public boolean freeRessource = false;
	
	/**
	 * Init an action with the goal to free the ressourcePool to the specified user
	 * @param resourcefulUser  the user to free to the ressourcePool
	 * @param resourcePool the ressourcePool to remove from the user
	 */
	public FreeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool, String name) {
		super(resourcefulUser, resourcePool, name);
	}

	@Override
	public void doStep() {
		if(resourcefulUser.getResource() != null) {
			resourcePool.freeRessource(resourcefulUser.getResource());
			resourcefulUser.resetResource();
			freeRessource = true;
			System.out.println(this);
		}
		
	}

	@Override
	public boolean isReady() {
		return freeRessource == false;
	}

	@Override
	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}

	@Override
	public boolean isFinished() {
		return freeRessource == true && resourcefulUser.getResource() == null;
	}
	
	@Override
	public String toString() {
		return name + " freeing resource to take resource from pool " + resourcePool.getFirstRessource().description();
	}
}
