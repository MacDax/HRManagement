package com.hackersm.hrm.hrmservice;

import java.util.List;

import com.hackersm.hrm.domain.Person;

public class PersonalHRResponse {

	private List<Person> persons;
	private String status;
	private List<ErrorMessages> errorMessages;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "PersonalHRResponse [persons=" + persons + "]";
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
