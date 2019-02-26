package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class Inventories extends PaginatedModel {

	
	List<Inventory>  inventories = new ArrayList<Inventory>();

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}
	
	public void addInventory(Inventory inventory){
		this.inventories.add(inventory);
	}


}