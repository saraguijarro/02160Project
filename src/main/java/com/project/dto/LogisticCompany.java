package com.project.dto;

import java.sql.Time;

import com.project.repository.*;


public class LogisticCompany extends User {

	private String id;
	private String name;
	private String password;
	private String details;
	private Time created;
	public ClientDatabase clientDatabase;
	
	public ClientDatabase getClientDatabase() {
		return clientDatabase;
	}

	public void setClientDatabase(ClientDatabase ClientDatabase) {
		clientDatabase = ClientDatabase;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Time getCreated() {
		return created;
	}

	public void setCreated(Time created) {
		this.created = created;
	}

}
