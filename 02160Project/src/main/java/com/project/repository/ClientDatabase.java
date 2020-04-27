package com.project.repository;

import com.project.dto.Client;
import com.project.dto.ResponseObject;

import java.util.ArrayList;

public class ClientDatabase {
	
	ArrayList<Client> clients;
	
	public ClientDatabase() {
		super();
		clients = new ArrayList<>();
	}
	
	
	
	public ResponseObject findMissingAndReplace(Client client) {
		
		ResponseObject response;		
		String missing = "";
		int code = 100;
		
		if (client.getName()==null) {
			missing = missing + "Name-";
			code = 101;
			client.setName("None");
		}
		if (client.getAddress()==null) {
			missing = missing + "Address-";
			code = 101;
			client.setAddress("None");
		}
		if (client.getReferencePerson()==null) {
			missing = missing + "Reference Person-";
			code = 101;
			client.setReferencePerson("None");
		}
		if (client.getEmail()==null) {
			missing = missing + "Email-";
			code = 101;
			client.setEmail("None");
		}
		if (code == 101) {missing = missing.substring(0, missing.length() - 1);}
		response = new ResponseObject("The following fields are missing: " + missing +".",code);
		return response;
	}
	
//this is the main method, it does the registration under certain conditions
	public ResponseObject registering(Client client) {
		ResponseObject missingResponse;
		ResponseObject response = null;
		
		missingResponse = this.findMissingAndReplace(client);
		if (client.getName().equals("None")) { //the client doesn't have a name. scenario 3
			response = new ResponseObject(103, "Clients needs a name to be registered, no changes were made!");
		}
		else {
			if (this.clientAlreadyRegistered(client)) { //the client is already registered. scenario 4
				response = new ResponseObject(102, "Client with the same name already registered, no changes were made!");
			}
			else {	
				if (missingResponse.getCode()==100) { //registration totally successful! scenario 1: all info was given
					response = new ResponseObject(100, "Client succesfully registered.");
				}
				else if (missingResponse.getCode()==101) { //registration done but info missing (missingResponse knows what is missing). scenario 2
					response = new ResponseObject(101, "Client registered, but some or all fields are missing.");
				}
				clients.add(client); //client added to the database
				
				this.giveID(client); //ID added to the client
				client.setHasID(true);
			} 
		}
		
		
		return response;
	}

	private boolean clientAlreadyRegistered(Client client) {
		boolean alreadyRegistered = false;
		
		for (int i=0; i<clients.size();i++) {
			if(clients.get(i).getName().equals(client.getName())) {
				alreadyRegistered = true;
			}
		}
		return alreadyRegistered;
	}


	public void giveID(Client client) {
		String prefix = "CL";
		String number = Integer.toString(this.clients.size()+1);
		String zeroes = "0".repeat(6-number.length());
		String id = prefix + zeroes + number;
		client.setClientID(id);
		
	}


//----2 methods used to find a client in the database by search word, and a potential filter-----------
	//-------n�1 returns a list with the found clients
	public ArrayList<Client> searchClient(String searchword, String filter) {
		ArrayList<Client> foundClients = new ArrayList<Client>();
		
		if (filter.equals("None")) { //search everything because no filter
			for (int i=0;i<this.clients.size();i++) {
				if (this.clients.get(i).isFound(searchword).getCode()!=130) {foundClients.add(this.clients.get(i));}
			}	
		}
		else if (filter.equals("Name")) { //search only name
			for (int i=0;i<this.clients.size();i++) {
				if (this.clients.get(i).getName().contains(searchword)){foundClients.add(this.clients.get(i));}
			}
		}
		else if (filter.equals("Address")) { //search only in the address
			for (int i=0;i<this.clients.size();i++) {
				if (this.clients.get(i).getAddress().getCity().contains(searchword)
				   || this.clients.get(i).getAddress().getCountry().contains(searchword)
				   || this.clients.get(i).getAddress().getPostcode().contains(searchword)
				   || this.clients.get(i).getAddress().getStreetName().contains(searchword)
				   || this.clients.get(i).getAddress().getStreetNumber().contains(searchword)
				   || this.clients.get(i).getAddress().getKeyWord().contains(searchword))
					{foundClients.add(this.clients.get(i));}
			}
		}
		else if (filter.equals("Reference Person")) {
			for (int i=0;i<this.clients.size();i++) {
				if (this.clients.get(i).getReferencePerson().contains(searchword)){foundClients.add(this.clients.get(i));}
			}
		}
		else if (filter.equals("Email")) {
			for (int i=0;i<this.clients.size();i++) {
				if (this.clients.get(i).getEmail().contains(searchword)){foundClients.add(this.clients.get(i));}
			}
		}
		
		
		return foundClients;
	}


	//---------n�2 returns a ResponseObject with information about the search
	public ResponseObject resultSearchClient(String searchword, String filter) {
		int code = 130;
		ArrayList<Client> foundClients = searchClient(searchword, filter);
		int numberOfClients = foundClients.size();
		if (numberOfClients>0) {code = 135;}
		String message = Integer.toString(numberOfClients) + " clients found with the searchword: ["+searchword+"] and the filter: ["+filter+"]";
		
		ResponseObject searchClientResponse = new ResponseObject(code, message);
		
		return searchClientResponse;
	}
	
	
	
}
