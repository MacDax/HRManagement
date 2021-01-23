package com.hackersm.hrm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.framework.dbdelegate.configuration.DatabaseManager;
import com.spring.boot.personsdb.transactions.GetPersonalDataDelegate;
import com.spring.boot.personsdb.transactions.ServicesDataDelegate;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public GetPersonalDataDelegate getPersonalDataDelegate() {
		return new GetPersonalDataDelegate();
	}
	
	@Bean
	public DatabaseManager dbManager() {
		return new DatabaseManager();
	}
	
	@Bean
	public ServicesDataDelegate getServicesDataDelegate() {
		return new ServicesDataDelegate();
	}
}
