package fr.univ_lille1.fil.coo.pool_scheduler.resources;

import java.util.ArrayList;
import java.util.List;

import fr.univ_lille1.fil.coo.pool_scheduler.resources.clothing.Clothing;

public abstract class Basket implements Resource {
	
	protected List<Clothing> clothing = new ArrayList<>();
	/* Bonus */
	public void addClothing(Clothing c){
		clothing.add(c);
	}
	
	public void removeClothing(Clothing c){
		clothing.remove(c);
	}
}
