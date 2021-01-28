package com.hackersm.hrm.questionaryservice;

import java.util.List;

import com.hackersm.hrm.domain.Subjects;
import com.hackersm.hrm.hrmservice.ErrorMessages;

public class SubjectDataResponse {

	private List<Subjects> subjects;
	private String status;
	private List<ErrorMessages> errorMessages;

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
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
