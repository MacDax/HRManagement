package com.hackersm.hrm.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
	//@JsonProperty("id")
	private int id;
	//@JsonProperty("fname")
	private String fname;
	//@JsonProperty("lname")
	private String lname;
	//@JsonProperty("address")
	private String address;
	//@JsonProperty("services")
	private List<Occupationservices> services;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@JsonProperty("birthDate")
	private LocalDate birthDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Occupationservices> getServices() {
		return services;
	}

	public void setServices(List<Occupationservices> services) {
		this.services = services;
	}

	
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", services="
				+ services + ", birthDate=" + birthDate + "]";
	}

	

	
}
