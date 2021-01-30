package com.hackersm.hrm.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hackersm.hrm.domain.ExQuestion;
import com.hackersm.hrm.domain.Person;
import com.hackersm.hrm.domain.QuestionType;
import com.hackersm.hrm.domain.Subjects;
import com.hackersm.hrm.domain.Teacher;
import com.hackersm.hrm.hrmservice.PersonalHRService;
import com.hackersm.hrm.questionaryservice.ExQuestionDataResponse;
import com.hackersm.hrm.questionaryservice.ExQuestionDataService;
import com.hackersm.hrm.questionaryservice.QuestionTypeDataService;
import com.hackersm.hrm.questionaryservice.SubjectsDataService;
import com.spring.boot.personsdb.transactions.PersonalDTO;
import com.spring.boot.questionary.transactions.ExQuestionDTO;
import com.spring.boot.questionary.transactions.QuestionTypeDTO;
import com.spring.boot.questionary.transactions.SubjectDTO;

@ManagedBean
public class ExQuestionsResourceDelegate {

	private static final Logger logger = LoggerFactory.getLogger(ExQuestionsResourceDelegate.class);
	@Inject
	ExQuestionDataService exQuestionDataService;
	@Inject
	SubjectsDataService subjectsDataService;
	@Inject
	QuestionTypeDataService questionTypeDataService;
	@Inject
	private PersonalHRService personalHRService;
	
	public Response getQuestionsDataResponse() {
		ExQuestionDataResponse qDataResponse = null;
		try {
			List<ExQuestionDTO> questionsData = exQuestionDataService.getQuestionsListData();
			logger.info("question data retreived : " + questionsData.size());
			qDataResponse = popoulateExQuestionsResponse(questionsData);
		} catch (Exception e) {
			e.printStackTrace();
			qDataResponse = new ExQuestionDataResponse();
			qDataResponse.setStatus("failure");
		}
		Response rs = Response.ok(qDataResponse).build();
		return rs;
	}
	
	private Map<Integer, Teacher> getPersonsList() throws Exception  {
		logger.info("get data list through delegate");
		List<PersonalDTO> dataList = personalHRService.getPersonDataList();
		logger.info("dataList size : " + dataList.size());	
		Map<Integer, Teacher> teachersList = new HashMap<>();
		for(PersonalDTO personDto : dataList) {
			Teacher teacher = new Teacher();
			teacher.setFname(personDto.getFname());
			teacher.setLname(personDto.getLname());
			teacher.setBirthDate(personDto.getBirthDate());
			teacher.setId(personDto.getId());
			teachersList.put(personDto.getId(), teacher);
			}
		return teachersList;
	}
	private Map<Integer, QuestionType> getQuestionTypes() {		
		List<QuestionTypeDTO> questionTypeList =null;
		try {
			questionTypeList = questionTypeDataService.getQuestionTypeList();
			logger.info("questiontypes retrieved :" + questionTypeList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<Integer, QuestionType> questionTypes = new HashMap<>();
		for(QuestionTypeDTO qtData : questionTypeList) {
			QuestionType qt = new QuestionType();
			qt.setQuestionTypeCode(qtData.getQuestionTypeCode());
			logger.info("question type text : " + qtData.getQuestionTypeName() + " qt code : " + qtData.getQuestionTypeCode());
			qt.setQuestionTypeName(qtData.getQuestionTypeName());
			questionTypes.put(qtData.getQuestionTypeCode(), qt);
		}
		return questionTypes;
	}
	
	private Map<Integer,Subjects> getSubjectNames() {
		List<SubjectDTO> subjectList =null;
		try {
			 subjectList = subjectsDataService.getSubjectsDataList();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		Map<Integer, Subjects> subjectNames = new HashMap<>();
		for(SubjectDTO subjectData : subjectList) {
			Subjects sub = new Subjects();
			sub.setSubjectCode(subjectData.getSubjectId());
			sub.setSubjectName(subjectData.getSubjectName());
			subjectNames.put(sub.getSubjectCode(), sub);
		}
		return subjectNames;
	}

	private ExQuestionDataResponse popoulateExQuestionsResponse(List<ExQuestionDTO> questionsData) {
		logger.info("question data retreived : " + questionsData.size());
		ExQuestionDataResponse response = new ExQuestionDataResponse();
		List<ExQuestion> questions = new ArrayList<>();
		
		//QustionType text
		Map<Integer, QuestionType> questionTypeList = getQuestionTypes();
		//subject names
		Map<Integer, Subjects> subjectNames = getSubjectNames();
		//teacher name - data
		Map<Integer, Teacher> teachersList = null;
		try {
			teachersList = getPersonsList();
		} catch (Exception e) {
			logger.info("error to retrieve teacherlist : ");
			e.printStackTrace();
		}
		
		for(ExQuestionDTO questionDTO : questionsData) {
			ExQuestion ex = new ExQuestion();
			ex.setQuestionId(questionDTO.getQuestionId());
			ex.setQuestionText(questionDTO.getQuestionText());
			int questionTypeCode = questionDTO.getQuestionTypeCode();
			logger.info("qt code in populate method : " +  questionTypeCode);
			ex.setQuestionTypeCode(questionTypeCode);
			if(questionTypeList.containsKey(questionTypeCode)) {
				logger.info("right q code in qdto : " + questionTypeCode);
				/*QuestionType questionTypeName = questionTypeList.stream()
						.filter(questionType -> questionTypeCode == questionType.getQuestionTypeCode())
						.findAny()
						.orElse(null);*/
				logger.info("questionTypeName found : " + questionTypeList.get(questionDTO.getQuestionTypeCode()).getQuestionTypeName());
				ex.setQuestionTypeText(questionTypeList.get(questionDTO.getQuestionTypeCode()).getQuestionTypeName());
			}
			ex.setSubjectCode(questionDTO.getSubjectCode());
			if(subjectNames.containsKey(questionDTO.getSubjectCode())) {
				logger.info("subjectName found :" + subjectNames.get(questionDTO.getSubjectCode()).getSubjectName());
				ex.setSubjectName(subjectNames.get(questionDTO.getSubjectCode()).getSubjectName());
			}
			ex.setTeacherId(questionDTO.getTeacherId());
			if(teachersList != null && teachersList.containsKey(questionDTO.getTeacherId())) {
				Teacher teacherObj = teachersList.get(questionDTO.getTeacherId());
				ex.setTeacher(teacherObj);
			}
			ex.setLastUpdated(questionDTO.getLastUpdated());
			questions.add(ex);
		}
		
		
		//subject name
		response.setExQuestions(questions);
		response.setStatus("success");
		return response;
	}
}
