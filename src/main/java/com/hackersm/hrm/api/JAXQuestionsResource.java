package com.hackersm.hrm.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("questionary")
public class JAXQuestionsResource {

private static final Logger logger = LoggerFactory.getLogger(JAXQuestionsResource.class);
	
	@Inject
	private SubjectsResourceDelegate subjectsResourceDelegate;
	@Inject
	private ExQuestionsResourceDelegate questionsResourceDelegate;
	
	@GET
	@Path("/questions")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExQuestionsData() {
		logger.info("questions : ");
		Response response = null;
		try {
			response = questionsResourceDelegate.getQuestionsDataResponse();
			return response;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
	
	//subjects list
	@GET
	@Path("/subjects")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSubjectsData(@Context UriInfo uriInfo) {
		logger.info("get subjectsData");
		Response response = null;
		try {
			response = subjectsResourceDelegate.getSubjectsList();
			return response;
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.info(ex.getMessage());
		}
		return response;
	}
	
	@GET
	@Path("/questiontypes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionTypeData() {
		logger.info("get questiontypes");
		Response response = null;
		try {
			response = subjectsResourceDelegate.getQuestionTypes();
			return response;
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.info(ex.getMessage());
		}
		return response;
	}
}
