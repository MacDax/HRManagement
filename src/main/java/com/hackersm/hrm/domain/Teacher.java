package com.hackersm.hrm.domain;

import java.util.List;

public class Teacher extends Person {

	List<Subjects> subjects;

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

}
