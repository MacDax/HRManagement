package com.hackersm.hrm.questionaryservice;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hackersm.hrm.hrmservice.PersonalHRService;
import com.spring.boot.questionary.transactions.GetSubjectsDataDelegate;
import com.spring.boot.questionary.transactions.SubjectDTO;

@ManagedBean("questionaryservice-v1")
public class SubjectsDataService {

	private static final Logger logger = LoggerFactory.getLogger(SubjectsDataService.class);
	@Inject
	GetSubjectsDataDelegate subjectsDataDelegate;
	
	public List<SubjectDTO> getSubjectsDataList() throws Exception {
		List<SubjectDTO> dataList = subjectsDataDelegate.getSubjectsData();
		logger.info("subjects list fetched from db : " + dataList.size());
		dataList.stream().forEach(subname -> System.out.println(subname.getSubjectName()));
		return dataList;
	}
}
