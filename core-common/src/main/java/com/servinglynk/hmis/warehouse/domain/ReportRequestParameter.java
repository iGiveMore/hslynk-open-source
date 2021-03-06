package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;

public class ReportRequestParameter extends BaseObject implements Serializable
{
	private static final long serialVersionUID = 1943429923033311936L;
	
	private String parameterName;
	private Serializable parameterValue;
	
	public ReportRequestParameter(String parameterName, Serializable parameterValue) {
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
	}
	
	public ReportRequestParameter() {
	}
	
	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public Serializable getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(Serializable parameterValue) {
		this.parameterValue = parameterValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportRequestParameter other = (ReportRequestParameter) obj;
		if (parameterName == null) {
			if (other.parameterName != null)
				return false;
		} else if (!parameterName.equals(other.parameterName))
			return false;
		if (parameterValue == null) {
			if (other.parameterValue != null)
				return false;
		} else if (!parameterValue.equals(other.parameterValue))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parameterName == null) ? 0 : parameterName.hashCode());
		result = prime * result + ((parameterValue == null) ? 0 : parameterValue.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "ReportRequestParameter [parameterName=" + parameterName + ", parameterValue=" + parameterValue + "]";
	}
}
