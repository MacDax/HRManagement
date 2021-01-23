package com.hackersm.hrm.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.hackersm"})
public class MainHrm  extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { MainHrm.class});
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainHrm.class, args);
	}
}
