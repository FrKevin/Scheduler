package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Resource;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;

public class TakeResourceAction<R extends Resource> extends ResourceAction<R>{
	
	protected boolean takeResource = false;
	
	public boolean isTakeResource() {
		return takeResource;
	}

	public TakeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
	}

	@Override
	public void doStep() {
		/* Voir la comprehension du sujet, si un resourcefulUser, a la ressource qu'il veut prendre */
		
		
	}

}
