package com.hackersm.hrm.domain;

import java.util.Date;

public class ExQuestion {
	
	private int questionId;
	private int questionTypeCode;
	private int subjectCode;
	private int teacherId;
	private String questionText;
	private Date lastUpdated;
	private String questionTypeText;
	private String subjectName;
	//private String teacherName;
	private Teacher teacher;
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getQuestionTypeCode() {
		return questionTypeCode;
	}

	public void setQuestionTypeCode(int questionTypeCode) {
		this.questionTypeCode = questionTypeCode;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getQuestionTypeText() {
		return questionTypeText;
	}

	public void setQuestionTypeText(String questionTypeText) {
		this.questionTypeText = questionTypeText;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

/*	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}*/

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	

}
