package fr.univ_lille1.fil.coo.pool_scheduler.resources;

import java.util.ArrayList;
import java.util.List;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.clothing.Clothing;

public class Basket implements Resource {
	
	protected List<Clothing> clothing = new ArrayList<>();
	protected String description;
	
	/**
	 * Basket where put clothes
	 * @param description
	 */
	public Basket(String description){
		this.description = description;
	}
	
	/* Bonus */
	public void addClothing(Clothing c){
		clothing.add(c);
	}
	
	public void removeClothing(Clothing c){
		clothing.remove(c);
	}

	@Override
	public String description() {
		return description;
	}

	public List<Clothing> getClothing() {
		return clothing;
	}
	
}
