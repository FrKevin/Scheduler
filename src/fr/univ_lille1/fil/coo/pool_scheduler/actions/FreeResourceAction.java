package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Resource;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;

public class FreeResourceAction<R extends Resource> extends ResourceAction<R>{
	
	public boolean freeRessource = false;
	
	/**
	 * Init an action with the goal to free the ressourcePool to the specified user
	 * @param resourcefulUser  the user to free to the ressourcePool
	 * @param resourcePool the ressourcePool to remove from the user
	 */
	public FreeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
	}

	@Override
	public void doStep() {
		if(resourcefulUser.getResource() != null) {
			resourcePool.freeRessource(resourcefulUser.getResource());
			resourcefulUser.resetResource();
			freeRessource = true;
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
	
	
}
