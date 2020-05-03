package com.project.dto;

import com.project.repository.ClientDatabase;
import java.io.Serializable;
import java.sql.Time;


public class LogisticCompany extends User {

	private long id;
	private String name;
	private String password;
	private String details;
	private Time created;
	ClientDatabase clientDatabase;

	public  LogisticCompany(){
    super();
	}
	
	public LogisticCompany(String name, String password, String details) {

		this.name = name;
		this.password = password;
		this.details = details;
		this.clientDatabase = new ClientDatabase();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClientDatabase getClientDatabase() {
		return clientDatabase;
	}

	public void setClientDatabase(ClientDatabase clientDatabase) {
		this.clientDatabase = clientDatabase;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
