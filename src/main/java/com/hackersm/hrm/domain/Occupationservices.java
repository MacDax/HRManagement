package com.hackersm.hrm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Occupationservices {
	//@JsonProperty("serviceType")
	private String serviceType;
	private String serviceName;
	private int id;
	
	
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
