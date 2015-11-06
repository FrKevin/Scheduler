package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Resource;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;

public class TakeResourceAction<R extends Resource> extends ResourceAction<R>{
	
	protected boolean takeResource = false;

	/**
	 * Action to affect a ressourcePool to an user
	 * @param resourcefulUser the user who will have the ressourcePool
	 * @param resourcePool the ressourcePool to affect to the user
	 */
	public TakeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
	}
	
	@Override
	public boolean isReady() {
		return takeResource == false;
	}
	
	@Override
	public void doStep() {
		if(resourcefulUser.getResource() != null ){
			throw new IllegalAccessError("The resource of user is not null");
		}
		R resource = resourcePool.getFirstRessource();
		if(resource != null){
			try {
				resource = resourcePool.provideRessource(resource);
				resourcefulUser.setResource(resource);
				takeResource = true;
			} catch (Exception e) {
			}
		}
		else{
			System.out.println("to take resource from pool " + resourcefulUser.toString() + "... failded");
		}
	}
	
	@Override
	public boolean isInProgress() {
		return isReady() && resourcefulUser.getResource() == null;
	}
	
	@Override
	public boolean isFinished() {
		return takeResource == true && resourcefulUser.getResource() != null;
	}
}