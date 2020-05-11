package com.project.dto;

import com.project.repository.*;


public class LogisticCompany extends User {

	private String name;
	private String password;
	private String details;
	
	public ClientDatabase clientDatabase = new ClientDatabase();
	public ContainerDB containerDatabase = new ContainerDB();
	public JourneyDB journeyDatabase = new JourneyDB();
	
	public JourneyDB getJourneyDatabase() {
		return journeyDatabase;
	}

	public ContainerDB getContainerDatabase() {
		return containerDatabase;
	}

	public ClientDatabase getClientDatabase() {
		return clientDatabase;
	}

	public  LogisticCompany(){
    super();
	}
	
	public LogisticCompany(String name, String password, String details) {

		this.name = name;
		this.password = password;
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
