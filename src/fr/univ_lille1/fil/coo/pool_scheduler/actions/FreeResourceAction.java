package fr.univ_lille1.fil.coo.pool_scheduler.actions;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.Resource;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcePool;
import fr.univ_lille1.fil.coo.pool_scheduler.resources.ResourcefulUser;

public class FreeResourceAction<R extends Resource> extends ResourceAction<R>{

	public FreeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
		// TODO Stub du constructeur généré automatiquement
	}

	@Override
	public void doStep() {
		// TODO Auto-generated method stub
		
	}

}
