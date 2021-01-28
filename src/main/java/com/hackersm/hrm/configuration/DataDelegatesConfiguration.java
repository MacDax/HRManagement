package com.hackersm.hrm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.questionary.transactions.GetSubjectsDataDelegate;

@Configuration
public class DataDelegatesConfiguration {

	@Bean
	public GetSubjectsDataDelegate getSubjectsDataDelegate() {
		return new GetSubjectsDataDelegate();
	}
}
