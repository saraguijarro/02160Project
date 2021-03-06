package com.project.repository;

import com.project.dto.Client;
import com.project.dto.ResponseObject;
import com.project.dto.dao.Repository;

import java.util.ArrayList;

public class ClientDatabase {

	Repository<Client> clientRepository;
	ArrayList<Client> clients;

	public ArrayList<Client> getClients() {
		return clients;
	}

	public ClientDatabase() {
		super();
		clientRepository = new ClientRepository();
		clients = new ArrayList<>();

	}

	// load from database
	public void findAll() {
		clients = clientRepository.findAll();
	}

	// this method needs to be called when application will end. For the entities to be written to database
	public void writeAllToDatabase() {
		clientRepository.putAllInDatabase(clients);
	}


	public ResponseObject findMissingAndReplace(Client client) {

		ResponseObject response;
		String missing = "";
		int code = 100;

		if (client.getName()==null || client.getName().equals("")) {
			missing = missing + "Name-";
			code = 101;
			client.setName("None");
		}
		if (client.getAddress()==null || client.getAddress().equals("")) {
			missing = missing + "Address-";
			code = 101;
			client.setAddress("None");
		}
		if (client.getReferencePerson()==null || client.getReferencePerson().equals("")) {
			missing = missing + "Reference Person-";
			code = 101;
			client.setReferencePerson("None");
		}
		if (client.getEmail()==null || client.getEmail().equals("")) {
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

		for (Client value : clients) {
			if (value.getName().equals(client.getName())) {
				alreadyRegistered = true;

				break;
			}
		}
		return alreadyRegistered;
	}


	public void giveID(Client client) {
		String prefix = "CL";
		String number = Integer.toString(this.clients.size());
		String zeroes = "0".repeat(6-number.length());
		String id = prefix + zeroes + number;
		client.setClientID(id);

	}


	//----2 methods used to find a client in the database by search word, and a potential filter-----------
	//-------n�1 returns a list with the found clients
	public ArrayList<Client> searchClient(String searchword, String filter) {
		ArrayList<Client> foundClients = new ArrayList<>();

		switch (filter) {
			case "None":  //search everything because no filter
				for (Client client : this.clients) {
					if (client.isFound(searchword).getCode() != 130) {
						foundClients.add(client);
					}
				}
				break;
			case "name":  //search only name
				for (Client client : this.clients) {
					if (client.getName().toLowerCase().contains(searchword.toLowerCase())) {
						foundClients.add(client);
					}
				}
				break;
			case "address":  //search only in the address
				for (Client client : this.clients) {
					if (client.getAddress().getCity().toLowerCase().contains(searchword.toLowerCase())
							|| client.getAddress().getCountry().toLowerCase().contains(searchword.toLowerCase())
							|| client.getAddress().getPostcode().toLowerCase().contains(searchword.toLowerCase())
							|| client.getAddress().getStreetName().toLowerCase().contains(searchword.toLowerCase())
							|| client.getAddress().getStreetNumber().toLowerCase().contains(searchword.toLowerCase())
					) {
						foundClients.add(client);
					}
				}
				break;
			case "reference person":
				for (Client client : this.clients) {
					if (client.getReferencePerson().toLowerCase().contains(searchword.toLowerCase())) {
						foundClients.add(client);
					}
				}
				break;
			case "email":
				for (Client client : this.clients) {
					if (client.getEmail().toLowerCase().contains(searchword)) {
						foundClients.add(client);
					}
				}
				break;
			case "id":
				for (Client client : this.clients) {
					if (client.getClientID().toLowerCase().contains(searchword.toLowerCase())) {
						foundClients.add(client);
					}
				}
				break;
		}


		return foundClients;
	}


	//---------n�2 returns a ResponseObject with information about the search
	public ResponseObject resultSearchClient(String searchword, String filter) {
		int code = 130;
		ArrayList<Client> foundClients = searchClient(searchword, filter);
		int numberOfClients = foundClients.size();
		if (numberOfClients>0) {code = 135;}
		String message = numberOfClients + " clients found with the searchword: ["+searchword+"] and the filter: ["+filter+"]";

		return new ResponseObject(code, message);
	}



}