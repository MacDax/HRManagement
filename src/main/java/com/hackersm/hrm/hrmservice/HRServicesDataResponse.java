package com.hackersm.hrm.hrmservice;

import java.util.List;

import com.hackersm.hrm.domain.Occupationservices;



public class HRServicesDataResponse {

	private List<Occupationservices> services;
	private String status;
	private List<ErrorMessages> errorMessages;

	public List<Occupationservices> getServices() {
		return services;
	}

	public void setServices(List<Occupationservices> services) {
		this.services = services;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ErrorMessages> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<ErrorMessages> errorMessages) {
		this.errorMessages = errorMessages;
	}

}
