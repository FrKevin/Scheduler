package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Resource;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;

/**
 * Base of an user's action using a resource
 *
 * @param <R>
 */
public abstract class ResourceAction<R extends Resource> extends Action {

	protected ResourcefulUser<R> resourcefulUser;
	protected ResourcePool<R> resourcePool;

	protected String name;
	/**
	 * Constructor of RessourceAction
	 * @param resourcefulUser User who's doing action
	 * @param resourcePool ressource used for the action
	 */
	public ResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool, String name) {
		this.resourcefulUser = resourcefulUser;
		this.resourcePool = resourcePool;
		this.name = name;
	}
	
	

}
