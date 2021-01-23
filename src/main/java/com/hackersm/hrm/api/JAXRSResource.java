package com.hackersm.hrm.api;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hackersm.hrm.domain.Person;



//http://localhost:9093/personalservice/v1/persons

@Path("persons")
public class JAXRSResource {

	@Inject
	private PersonalResourceDelegate personalResourceDelegate;
	private static final Logger logger = LoggerFactory.getLogger(JAXRSResource.class);
	
	
	//servicesData
	@GET
	@Path("/services")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getServicesData(@Context UriInfo uriIfo) {
		logger.info("get servicesData");
		Response response = null;
		try{
			response = personalResourceDelegate.getServicesData();
			return response;
		}catch(SQLException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	
	@GET
	@Path("/personsdata")
	@Produces(MediaType.APPLICATION_JSON)
	public Response index(@Context UriInfo uriInfo) throws Exception {
		logger.info("in index getJAXResource ");
		Response response = null;
		try {
			response = personalResourceDelegate.getPersonsList();
			return response;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@POST
	@Path("/personsdata")
	//@Accepts(MediaType.APPLICATION_JSON)
	public Response saveData(@Context UriInfo uriInfo, List<Person> personData) {
		logger.info("input personData : " + personData.toString());
		Response rs = personalResourceDelegate.savePersonsList(personData);
		return rs;
	}
}
