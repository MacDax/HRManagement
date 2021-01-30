package com.hackersm.hrm.questionaryservice;

import java.util.List;

import com.hackersm.hrm.domain.ExQuestion;
import com.hackersm.hrm.hrmservice.ErrorMessages;

public class ExQuestionDataResponse {

	List<ExQuestion> exQuestions;
	private String status;
	private List<ErrorMessages> errorMessages;

	public List<ExQuestion> getExQuestions() {
		return exQuestions;
	}

	public void setExQuestions(List<ExQuestion> exQuestions) {
		this.exQuestions = exQuestions;
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
