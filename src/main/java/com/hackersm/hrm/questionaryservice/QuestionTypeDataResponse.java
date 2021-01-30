package com.hackersm.hrm.questionaryservice;

import java.util.List;

import com.hackersm.hrm.domain.QuestionType;
import com.hackersm.hrm.hrmservice.ErrorMessages;

public class QuestionTypeDataResponse {

	private List<QuestionType> questionTypes;
	private String status;
	private List<ErrorMessages> errorMessages;

	public List<QuestionType> getQuestionTypes() {
		return questionTypes;
	}

	public void setQuestionTypes(List<QuestionType> questionTypes) {
		this.questionTypes = questionTypes;
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
