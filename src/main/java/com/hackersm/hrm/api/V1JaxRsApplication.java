package com.hackersm.hrm.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("v1")
public class V1JaxRsApplication extends javax.ws.rs.core.Application {

	private final Set<Object> singletons = new HashSet<Object>();
	private final Set<Class<?>> prototypeResources = new HashSet<Class<?>>();
	
	public V1JaxRsApplication() {
		prototypeResources.add(JAXRSResource.class);
		prototypeResources.add(JAXQuestionsResource.class);
	}
	
	public Set<Class<?>> getClasses() {
		return prototypeResources;
	}
	
	public Set<Object> getSingletons() {
		return singletons;
	}
}
