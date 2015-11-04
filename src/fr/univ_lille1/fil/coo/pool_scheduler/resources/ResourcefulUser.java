package fr.univ_lille1.fil.coo.pool_scheduler.resources;

public class ResourcefulUser<R extends Resource> {

	protected R resource;
	
	public R getResource() {
		return resource;
	}
	
	public void setRessource(R resource) {
		this.resource = resource;
	}
	
	public void resetResource() {
		this.resource = null;
	}
}
