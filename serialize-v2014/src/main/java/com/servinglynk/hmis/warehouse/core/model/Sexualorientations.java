package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("sexualorientations")
public class Sexualorientations extends PaginatedModel {


	@JsonProperty("sexualorientations")
	List<Sexualorientation> sexualorientations = new ArrayList<Sexualorientation>();

	public List<Sexualorientation> getSexualorientations() {
		return sexualorientations;
	}

	public void setSexualorientations(List<Sexualorientation> sexualorientations) {
		this.sexualorientations = sexualorientations;
	}
	
	public void addSexualorientation(Sexualorientation sexualorientation){
		this.sexualorientations.add(sexualorientation);
	}
	
}
