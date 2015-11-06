package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Resource;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;

public class TakeResourceAction<R extends Resource> extends ResourceAction<R>{
	
	protected boolean takeResource = false;
	
	protected String status = FAIL_STATUS;
	
	protected final static String SUCCESS_STATUS = "sucess";
	
	protected final static String FAIL_STATUS = "fail";


	/**
	 * Action to affect a ressourcePool to an user
	 * @param resourcefulUser the user who will have the ressourcePool
	 * @param resourcePool the ressourcePool to affect to the user
	 */
	public TakeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool, String name) {
		super(resourcefulUser, resourcePool, name);
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
				setTakeResource(true);
			} catch (Exception e) {
			
			}
		}
		else{
			setTakeResource(false);
		}
	}
	
	protected void setTakeResource(boolean takeResource) {
		this.takeResource = takeResource;
		if(!takeResource) {
			status = FAIL_STATUS;
		}
		status = SUCCESS_STATUS;
	}
	
	@Override
	public boolean isInProgress() {
		return isReady() && resourcefulUser.getResource() == null;
	}
	
	@Override
	public boolean isFinished() {
		return takeResource == true && resourcefulUser.getResource() != null;
	}
	
	@Override
	public String toString() {
		return name + " trying to take resource from pool " + resourcePool.getFirstRessource().description() + "... " + status;
	}
}