package com.project.repository;

import com.project.dto.Container;
import com.project.dto.Jou;
import com.project.dto.ResponseObject;
import com.project.dto.dao.Repository;

import java.util.ArrayList;

public class JourneyDB {

	Repository<Jou> jouRepository;
	ArrayList<Jou> journeys;
	public JourneyDB() {
		super();
		journeys = new ArrayList<>();
		jouRepository = new JourneyRepository();
//		journeys = jouRepository.findAll();

		journeys = new ArrayList<>();
	}

	// this method needs to be called when application will end. For the entities to be written to database
	public void writeAllToDatabase() {
		jouRepository.putAllInDatabase(journeys);
	}



    public ArrayList<Jou> getJourneys() {
		return journeys;
	}
    
	public void setJourneys(ArrayList<Jou> journeys) {
		this.journeys = journeys;
	}


//this is the main method, it does the registration under certain conditions
	public ResponseObject registerStep1(Jou journey) {
		ResponseObject response = new ResponseObject(200,"Error");
		String errorMessage = "No changes were made!";
			
		if (journey.getOriginPort()==(null)) { //the client doesn't have a port of Origin	
			errorMessage += " Journey needs a port of origin to be registered.";
			response = new ResponseObject(203, errorMessage);
		}
		
		if (journey.getDestination()==(null)) { //the client doesn't have a Destination
			errorMessage += " Journey needs a destination to be registered.";
			response = new ResponseObject(203, errorMessage);
		}
		
		if (journey.getContent()==(null)) { //the client doesn't have a Content		
			errorMessage +=" Journey needs a content to be registered.";
			response = new ResponseObject(203, errorMessage);
		}
		
		if (journey.getCompany()==(null)) { //the client doesn't have a Company
			errorMessage+=" Journey needs a company to be registered.";
			response = new ResponseObject(203, errorMessage);
		}
							
		if (response.getCode()==200) { //registration totally successful! 	
			response.setMessage("Journey successfully created.");
				
			//journeys.add(journey); //journey added to the database
				
			this.giveID(journey); //ID added to the journey
			journey.setHasID(true);
		}
					
		return response;
	}
			
			
	public void registerStep2(Jou j , Container c) {
			
		ContainerDB CDB = new ContainerDB();
			
		j.setC(c);
		journeys.add(j); //journey added to the database
		c.setInJourney(true);
		CDB.giveID(c);
	}


	public boolean containerInAJourney(String containerID) {
		for(int i = 0 ; i<journeys.size() ; i++) {
			if(journeys.get(i).getC().getContainerID().equals(containerID)) {
				return true;
			}
		}
		return false;
	}

	static int counter = 1;
	public void giveID(Jou journey) {
		String prefix = "JO";
		String number = Integer.toString(counter);
		String zeroes = "0".repeat(6-number.length());
		String id = prefix + zeroes + number;
		journey.setJourneyID(id);			
		counter++;
	}


//Methods used to find a journey in the database by search word, and a potential filter-----------

	//returns a list with the found clients
	public ArrayList<Jou> searchJourney(String searchword, String filter) {
		ArrayList<Jou> foundJourneys = new ArrayList<Jou>();
				
		if (filter.equals("None")) { //search everything because no filter
			for (int i=0;i<this.journeys.size();i++) {
				if (this.journeys.get(i).isFound(searchword).getCode()!=230) {foundJourneys.add(this.journeys.get(i));}
			}	
		}
		else if (filter.equals("Port of Origin")) { //search only for port of origin
			for (int i=0;i<this.journeys.size();i++) {
				if (this.journeys.get(i).getOriginPort().toLowerCase().contains(searchword.toLowerCase())){foundJourneys.add(this.journeys.get(i));}
			}
		}
		else if (filter.equals("Destination")) { //search only for destination
			for (int i=0;i<this.journeys.size();i++) {
				if (this.journeys.get(i).getDestination().toLowerCase().contains(searchword.toLowerCase())){foundJourneys.add(this.journeys.get(i));}
			}
		}
		else if (filter.equals("Content")) { //search only for port of content
			for (int i=0;i<this.journeys.size();i++) {
				if (this.journeys.get(i).getContent().toLowerCase().contains(searchword.toLowerCase())){foundJourneys.add(this.journeys.get(i));}
			}
		}
		else if (filter.equals("Company")) { //search only for port of company
			for (int i=0;i<this.journeys.size();i++) {
				if (this.journeys.get(i).getCompany().toLowerCase().contains(searchword.toLowerCase())){foundJourneys.add(this.journeys.get(i));}
			}
		}						
		return foundJourneys;
	}


	//returns a ResponseObject with information about the search
	public ResponseObject resultSearchJourney(String searchword, String filter) {
		int code = 230;
		ArrayList<Jou> foundJourneys = searchJourney(searchword, filter);
		int numberOfJourneys = foundJourneys.size();
		if (numberOfJourneys>0) {code = 135;}
		String message = Integer.toString(numberOfJourneys) + " journeys found with the searchword: ["+searchword+"] and the filter: ["+filter+"]";
			
		ResponseObject searchJourneyResponse = new ResponseObject(code, message);
				
		return searchJourneyResponse;
	}
}
