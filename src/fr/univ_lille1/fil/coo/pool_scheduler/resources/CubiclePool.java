package fr.univ_lille1.fil.coo.pool_scheduler.resources;

/**
 * Class managing cubicle ressources
 *
 */
public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int capacity) {
		super(capacity);
	}
	
	@Override
	public String toString() {
		return super.toString() + " cubicle";
	}

}
