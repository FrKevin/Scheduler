package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Resource;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;

public class FreeResourceAction<R extends Resource> extends ResourceAction<R>{

	public FreeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
	}

	@Override
	public void doStep() {
		if(resourcefulUser.getResource() != null) {
			resourcePool.freeRessource(resourcefulUser.getResource());
			resourcefulUser.resetResource();
		}
	}

	@Override
	public boolean isReady() {
		return resourcefulUser != null && resourcefulUser.getResource() != null;
	}

	@Override
	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}

	@Override
	public boolean isFinished() {
		return resourcefulUser.getResource() == null;
	}
	
	
}
