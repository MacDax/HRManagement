package com.hackersm.hrm.questionaryservice;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.boot.questionary.transactions.ExQuestionDTO;
import com.spring.boot.questionary.transactions.ExQuestionDataDelegate;

@ManagedBean
public class ExQuestionDataService {

	private static final Logger logger = LoggerFactory.getLogger(ExQuestionDataService.class);
	@Inject
	private ExQuestionDataDelegate exQuestionDataDelegate;
	
	public List<ExQuestionDTO> getQuestionsListData() throws Exception {
		logger.info("exquestion data list ");
		return exQuestionDataDelegate.getExQuestionsList();
	}
}
