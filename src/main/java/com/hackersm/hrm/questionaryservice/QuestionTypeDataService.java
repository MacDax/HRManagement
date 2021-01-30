package com.hackersm.hrm.questionaryservice;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.boot.questionary.transactions.GetQuestionTypeDataDelegate;
import com.spring.boot.questionary.transactions.QuestionTypeDTO;

@ManagedBean
public class QuestionTypeDataService {

	private static final Logger logger = LoggerFactory.getLogger(SubjectsDataService.class);
	@Inject
	GetQuestionTypeDataDelegate questionTypeDataDelegate;
	
	public List<QuestionTypeDTO> getQuestionTypeList() throws Exception {
		logger.info("get quesstionType data ");
		return questionTypeDataDelegate.getQuestionTypeList();
	}
}
