package com.hackersm.hrm.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hackersm.hrm.domain.Occupationservices;
import com.hackersm.hrm.domain.Person;
import com.hackersm.hrm.hrmservice.ErrorMessages;
import com.hackersm.hrm.hrmservice.HRServicesDataResponse;
import com.hackersm.hrm.hrmservice.HRServicesDataService;
import com.hackersm.hrm.hrmservice.PersonalHRResponse;
import com.hackersm.hrm.hrmservice.PersonalHRService;
import com.spring.boot.personsdb.transactions.PersonalDTO;
import com.spring.boot.personsdb.transactions.ServicesDTO;


@ManagedBean
public class PersonalResourceDelegate {

	private static final Logger logger = LoggerFactory.getLogger(PersonalResourceDelegate.class);
	@Inject
	private PersonalHRService personalHRService;
	@Inject
	private HRServicesDataService hrServicesData;
	
	public Response getServicesData() throws Exception {
		logger.info("get services data : ");
		List<ServicesDTO> servicesList = hrServicesData.getServicesList();
		HRServicesDataResponse serviceResponse = populateServicesData(servicesList);
		Response rs = Response.ok().entity(serviceResponse).build();
		return rs;
	}
	
	private HRServicesDataResponse populateServicesData(List<ServicesDTO> servicesList) {
		if(null == servicesList) {
			HRServicesDataResponse response = new HRServicesDataResponse();
			response.setStatus("Failure");
			return response;
		}
		
		HRServicesDataResponse servicesResponse = new HRServicesDataResponse();
		List<Occupationservices> occServices = new ArrayList<>();
		servicesList.stream().forEach(servicedt -> {
			Occupationservices os = new Occupationservices();
			os.setId(servicedt.getServiceId());
			os.setServiceName(servicedt.getServiceName());
			logger.info("service name : " + servicedt.getServiceName() + " id : " + servicedt.getServiceId() + " "
					+ " type : " + servicedt.getServiceType());
			os.setServiceType(servicedt.getServiceType());
			occServices.add(os);
		});
		servicesResponse.setServices(occServices);
		servicesResponse.setStatus("Success");
		return servicesResponse;
	}

	public Response savePersonsList(List<Person> personsList) {
		boolean result = personalHRService.savePersonsData(personsList);
		if(result) {
			logger.info("data saved");
			PersonalHRResponse personalHRResponse = new PersonalHRResponse();
			personalHRResponse.setStatus("Success");
			Response rs = Response.ok().entity(personalHRResponse).build();
			return rs;
		}
		PersonalHRResponse personalHRResponse = populateErrorMessage();
		Response rs = Response.ok().entity(personalHRResponse).build();
		return rs;
	}
	
	public Response getPersonsList() throws Exception {
		logger.info("get data list through delegate");
		List<PersonalDTO> dataList = personalHRService.getPersonDataList();
		logger.info("dataList size : " + dataList.size());		
		
		PersonalHRResponse personalHRResponse = populatePersonsData(dataList);
		Response rs = Response.ok().entity(personalHRResponse).build();
		return rs;
	}

	private PersonalHRResponse populatePersonsData(List<PersonalDTO> dataList) {
		if(null == dataList) {
			PersonalHRResponse personalHRResponse = populateErrorMessage();
			return personalHRResponse;
		}
		List<Person> hrPersonsList = new ArrayList<>();
		dataList.stream().forEach(persondt -> {
			Person person = new Person();
			person.setFname(persondt.getFname());
			person.setLname(persondt.getLname());
			person.setId(persondt.getId());
			hrPersonsList.add(person);
		});
		PersonalHRResponse personalHRResponse = new PersonalHRResponse();
		personalHRResponse.setPersons(hrPersonsList);
		return personalHRResponse;
	}

	private PersonalHRResponse populateErrorMessage() {
		PersonalHRResponse personalHRResponse = new PersonalHRResponse();
		personalHRResponse.setStatus("FAILURE");
		ErrorMessages errorMessage = new ErrorMessages();
		errorMessage.setCode("NODATA-101");
		errorMessage.setMessage("No data returned");
		personalHRResponse = new PersonalHRResponse();
		return personalHRResponse;
	}
}
