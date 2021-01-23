package com.hackersm.hrm.configuration;

import java.util.HashSet;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;

import javax.annotation.ManagedBean;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.glassfish.jersey.servlet.init.JerseyServletContainerInitializer;
import org.springframework.boot.web.servlet.ServletContextInitializer;

@ManagedBean
public class JersyInitialization implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Set<Class<?>> x = new HashSet<>();
		ServiceLoader<JerseyServletContainerConfigurationProvider> y = ServiceLoader.load(JerseyServletContainerConfigurationProvider.class);
		//System.out.println("y :  " + y.iterator().hasNext());
		try{
			for(JerseyServletContainerConfigurationProvider o : y) {
				x.addAll(o.getConfigurationClasses());
			}
		}catch(ServiceConfigurationError localServiceConfigurationError) {		}
		new JerseyServletContainerInitializer().onStartup(x, servletContext);
	}

}
