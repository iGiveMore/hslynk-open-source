package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;



@JsonRootName("errors")
public class Errors extends ClientModel {

	@JsonProperty( "error")
	protected List<Error> error;

	public List<Error> getError() {
		return error;
	}

	public void setError(List<Error> error) {
		this.error = error;
	}

	public void setErrors(List<Error> error) {
		this.error = error;
	}
	public void addError(Error newError) {
		if (error == null) {
			this.error = new ArrayList<Error>();
		}
		error.add(newError);
	}

}
