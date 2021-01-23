package com.hackersm.hrm.hrmservice;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.boot.personsdb.transactions.ServicesDTO;
import com.spring.boot.personsdb.transactions.ServicesDataDelegate;

@ManagedBean("HRServicesTypes-v1")
public class HRServicesDataService {

	private static final Logger logger = LoggerFactory.getLogger(HRServicesDataService.class);
	@Inject
	private  ServicesDataDelegate getServicesDataDelegate;
	
	public List<ServicesDTO> getServicesList() throws Exception {
		logger.info("getservices list for hrservice: ");
		List<ServicesDTO> services = getServicesDataDelegate.getServicesDataList();
		services.stream().forEach(service -> logger.info(service.getServiceName()));
		return services;
	}
}
