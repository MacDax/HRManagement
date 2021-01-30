package com.hackersm.hrm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.questionary.transactions.ExQuestionDataDelegate;
import com.spring.boot.questionary.transactions.GetQuestionTypeDataDelegate;
import com.spring.boot.questionary.transactions.GetSubjectsDataDelegate;

@Configuration
public class DataDelegatesConfiguration {

	@Bean
	public GetSubjectsDataDelegate getSubjectsDataDelegate() {
		return new GetSubjectsDataDelegate();
	}
	
	@Bean
	public GetQuestionTypeDataDelegate getQuestionTypeDataDelegate() {
		return new GetQuestionTypeDataDelegate();
	}
	
	@Bean
	public ExQuestionDataDelegate getExQuestionDataDelegate() {
		return new ExQuestionDataDelegate();
	}
}
