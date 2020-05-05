package com.project.dto;

import com.project.repository.JourneyDB;

public class Client {
	
	public Client() {
		super();
	}

	public Client(String name) {
		super();
		this.name = name;
	}

	public Client(String name, Address address, String referencePerson, String email) {
		super();
		this.name = name;
		this.address = address;
		this.referencePerson = referencePerson;
		this.email = email;
	}
    private JourneyDB JDB;
	private String name;
	private Address address;
	private String referencePerson;
	private String email;
	private String clientID;
	private Boolean hasID;
	
//------all the setters and getters----------

	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setAddress(String add) {
		if (add.equals("None")) {this.setAddress(new Address("None","None","None","None","None"));}
		else {this.setAddress(new Address(add));}
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

	public JourneyDB getJDB() {
		return JDB;
	}

	public void setJDB(JourneyDB jdb) {
		this.JDB = jdb;
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
	
	//updating with full address
	public ResponseObject update(String updateChoice, Address updateContent) {
		ResponseObject updateResponse = null;
		int code=116;
		if (updateChoice.equals("address2")) {this.setAddress(updateContent);code=115;}
		if (code!=116) {updateResponse = new ResponseObject(code, "Client information succesfully updated");}
		return updateResponse;
	}
//------------end of Update Client method--------------

//--isFound() method, used in the "searchingClient()" method from the ClientDatabase class
//used to find if a substring can be found in the information of a client	
	public ResponseObject isFound(String searchword) {
		int code = 130;
		String message = "";
		
		if (this.name.contains(searchword)){code = 131; message="name";}
		else if (this.address.getCity().contains(searchword)
			   ||this.address.getCountry().contains(searchword)
			   ||this.address.getPostcode().contains(searchword)
			   ||this.address.getStreetName().contains(searchword)
			   ||this.address.getStreetNumber().contains(searchword)
			   ||this.address.getKeyWord().contains(searchword))
				{code = 132;message = "address";}
		else if(this.referencePerson.contains(searchword)){code = 133; message="reference person";}
		else if(this.email.contains(searchword)){code = 134; message="email";}
				
		ResponseObject isFoundResponse = new ResponseObject(code,message);
		return isFoundResponse;
	}
	
	
	
	
	

}
