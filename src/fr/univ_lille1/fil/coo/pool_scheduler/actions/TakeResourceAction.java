package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Resource;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;


/**
 * 
 * Class to put a ressource to an user
 *
 * @param <R> type of the ressource
 */
public class TakeResourceAction<R extends Resource> extends ResourceAction<R>{
	
	protected boolean takeResource = false;
	
	protected final static String SUCCESS_STATUS = "success";
	
	protected final static String FAIL_STATUS = "failed";


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
		System.out.print(this);
		R resource = resourcePool.getFirstRessource();
		if(resource != null){
			try {
				resource = resourcePool.provideRessource(resource);
				resourcefulUser.setResource(resource);
				this.takeResource = true;
				System.out.println(SUCCESS_STATUS);
			} catch (Exception e) {
				this.takeResource = false;
				System.out.println(FAIL_STATUS);

			}
		}
	}
	
	protected void setTakeResource(boolean takeResource) {
		this.takeResource = takeResource;
	}
	
	
	protected String getStatus() {
		return isFinished() ? SUCCESS_STATUS : FAIL_STATUS;
	}
	
	@Override
	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}
	
	@Override
	public boolean isFinished() {
		return takeResource == true && resourcefulUser.getResource() != null;
	}
	
	@Override
	public String toString() {
		return name + " trying to take resource from " + resourcePool + "... ";
	}
}