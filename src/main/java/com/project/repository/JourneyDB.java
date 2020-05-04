package com.project.repository;


import com.project.dto.Container;
import com.project.dto.Jou;
import com.project.dto.ResponseObject;

import java.util.ArrayList;

public class JourneyDB {

	ArrayList<Jou> journeys;
    Container container;
	public JourneyDB() {
		super();
		journeys = new ArrayList<>();
	}

	
	
	//this is the main method, it does the registration under certain conditions
		public ResponseObject registering(Jou journey) {
			ResponseObject response = new ResponseObject(200,"Error");
			String errorMessage=" No changes were made!";
			
			
			if (journey.getOriginPort().equals(null)) { //the client doesn't have a port of Origin
				
				errorMessage += " Journey needs a port of origin to be registered.";
				response = new ResponseObject(203, errorMessage);
			}
			if (journey.getDestination().equals(null)) { //the client doesn't have a Destination
				
				errorMessage += " Journey needs a destination to be registered.";
				response = new ResponseObject(203, errorMessage);
			}
			if (journey.getContent().equals(null)) { //the client doesn't have a Content
				errorMessage +=" Journey needs a content to be registered.";
				response = new ResponseObject(203, errorMessage);
			}
			if (journey.getCompany().equals(null)) { //the client doesn't have a Company
				errorMessage+=" Journey needs a company to be registered.";
				response = new ResponseObject(203, errorMessage);
			}
				
			
			
			
			if (response.getCode()==200) { //registration totally successful! 
				
				response.setMessage("Journey successfully registered.");
				
				
				//journeys.add(journey); //journey added to the database
				
				this.giveID(journey); //ID added to the journey
			}
			
				
			return response;
			}
			
			
			




		public void giveID(Jou journey) {
			String prefix = "JO";
			String number = Integer.toString(this.journeys.size()+1);
			String zeroes = "0".repeat(6-number.length());
			String id = prefix + zeroes + number;
			journey.setJourneyID(id);
			
		}


	
	


		//---- methods used to find a journey in the database by search word, and a potential filter-----------
			//-------returns a list with the found clients
			public ArrayList<Jou> searchJourney(String searchword, String filter) {
				ArrayList<Jou> foundJourneys = new ArrayList<Jou>();
				
				if (filter.equals("None")) { //search everything because no filter
					for (int i=0;i<this.journeys.size();i++) {
						if (this.journeys.get(i).isFound(searchword).getCode()!=130) {foundJourneys.add(this.journeys.get(i));}
					}	
				}
				else if (filter.equals("Port of origin")) { //search only for port of origin
					for (int i=0;i<this.journeys.size();i++) {
						if (this.journeys.get(i).getOriginPort().contains(searchword)){foundJourneys.add(this.journeys.get(i));}
					}
				}
				else if (filter.equals("Destination")) { //search only for destination
					for (int i=0;i<this.journeys.size();i++) {
						if (this.journeys.get(i).getDestination().contains(searchword)){foundJourneys.add(this.journeys.get(i));}
					}
				}
				else if (filter.equals("Content")) { //search only for port of content
					for (int i=0;i<this.journeys.size();i++) {
						if (this.journeys.get(i).getContent().contains(searchword)){foundJourneys.add(this.journeys.get(i));}
					}
				}
				else if (filter.equals("Company")) { //search only for port of company
					for (int i=0;i<this.journeys.size();i++) {
						if (this.journeys.get(i).getCompany().contains(searchword)){foundJourneys.add(this.journeys.get(i));}
					}
				}
				
				
				return foundJourneys;
			}


			// returns a ResponseObject with information about the search
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
