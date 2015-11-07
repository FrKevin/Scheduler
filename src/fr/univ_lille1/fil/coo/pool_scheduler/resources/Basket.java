package fr.univ_lille1.fil.coo.pool_scheduler.resources;



/**
 * Class reprensenting a basket
 *
 */
public class Basket implements Resource {
	
	protected String description;
	
	/**
	 * Basket where put clothes
	 * @param description
	 */
	public Basket(String description){
		this.description = description;
	}
	
	@Override
	public String description() {
		return description;
	}

	
}
