package com.hackersm.hrm.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hackersm.hrm.domain.QuestionType;
import com.hackersm.hrm.domain.Subjects;
import com.hackersm.hrm.questionaryservice.QuestionTypeDataResponse;
import com.hackersm.hrm.questionaryservice.QuestionTypeDataService;
import com.hackersm.hrm.questionaryservice.SubjectDataResponse;
import com.hackersm.hrm.questionaryservice.SubjectsDataService;
import com.spring.boot.questionary.transactions.QuestionTypeDTO;
import com.spring.boot.questionary.transactions.SubjectDTO;

@ManagedBean
public class SubjectsResourceDelegate {

	private static final Logger logger = LoggerFactory.getLogger(SubjectsResourceDelegate.class);
	@Inject
	SubjectsDataService subjectsDataService;
	@Inject
	QuestionTypeDataService questionTypeDataService;
	
	public Response getQuestionTypes() {
		logger.info("get questiontypes ");
		QuestionTypeDataResponse response = null;
		try {
			List<QuestionTypeDTO> questionTypeList = questionTypeDataService.getQuestionTypeList();
			response = populateQuestionTypeResponse(questionTypeList);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.info("exception during questiontype service call");
			response = new QuestionTypeDataResponse();
			response.setStatus("failure");
		}
		Response rs = Response.ok().entity(response).build();
		return rs;
	}
	
	private QuestionTypeDataResponse populateQuestionTypeResponse(List<QuestionTypeDTO> questionTypeList) {
		QuestionTypeDataResponse qtypeResponse = new QuestionTypeDataResponse();
		qtypeResponse.setStatus("success");
		List<QuestionType> questionTypes = new ArrayList<>();
		qtypeResponse.setQuestionTypes(questionTypes);
		for(QuestionTypeDTO qtData : questionTypeList) {
			QuestionType qt = new QuestionType();
			qt.setQuestionTypeCode(qtData.getQuestionTypeCode());
			qt.setQuestionTypeName(qtData.getQuestionTypeName());
			questionTypes.add(qt);
		}
		return qtypeResponse;
	}

	public Response getSubjectsList() throws Exception {
		logger.info("get subjects list : ");
		SubjectDataResponse subjectsResponse = null;
		try {
			List<SubjectDTO> subjectList = subjectsDataService.getSubjectsDataList();
			subjectsResponse = populateSubjetsData(subjectList);
		}catch(Exception ex) {
			logger.info("exception during dataservice call");
			subjectsResponse = new SubjectDataResponse();
			subjectsResponse.setStatus("failure");
		}
		Response rs = Response.ok().entity(subjectsResponse).build();
		return rs;
	}


	private SubjectDataResponse populateSubjetsData(List<SubjectDTO> subjectList) {
		SubjectDataResponse response = new SubjectDataResponse();
		List<Subjects> subjects = new ArrayList<>();
		response.setSubjects(subjects);
		response.setStatus("success");
		for(SubjectDTO subjectData : subjectList) {
			Subjects subject = new Subjects();
			subject.setSubjectCode(subjectData.getSubjectId());
			subject.setSubjectName(subjectData.getSubjectName());
			subjects.add(subject);
		}
		return response;
	}
	
}
