package com.project.dto;

import com.project.repository.JourneyDB;

public class Client extends User{

	private String name;
	private String address;
	private String referencePerson;
	private String email;
	private String clientID;
	private Boolean hasID;
	private JourneyDB journeyDB;
	private String password;

	public Client(){
	super();
	}

	public Client(String name, String address, String referencePerson, String email, String password) {
		super();
		this.name = name;
		this.address = address;
		this.referencePerson = referencePerson;
		this.email = email;
		this.password = password;
	}


	
	
//------all the setters and getters----------

	

	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public JourneyDB getJourneyDB() {
		return journeyDB;
	}
	public void setJourneyDB(JourneyDB journeyDB) {
		this.journeyDB = journeyDB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReferencePerson() {
		return referencePerson;
	}
	public void setReferencePerson(String referencePerson) {
		this.referencePerson = referencePerson;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getHasID() {
		return hasID;
	}
	public void setHasID(Boolean hasID) {
		this.hasID = hasID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//----------end of setters and getters----------

	
//---------Update Client Method:------------
	
	//updating any field with a string (including address keyword)
	public ResponseObject update(String updateChoice, String updateContent) {
		ResponseObject updateResponse = null;
		int code=116; //116 = error code by default (it is changed if an update successfully happens)
		if (updateChoice.equals("name")) {this.setName(updateContent);code=111;}
		else if (updateChoice.equals("address1")) {this.setAddress(updateContent);code=112;}
		else if (updateChoice.equals("reference person")) {this.setReferencePerson(updateContent);code=113;}
		else if (updateChoice.equals("email")) {this.setEmail(updateContent);code=114;}
		
		if (code!=116) {updateResponse = new ResponseObject(code, "Client information succesfully updated");}
		return updateResponse;
	}


}
