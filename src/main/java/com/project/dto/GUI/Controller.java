package com.project.dto.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.project.dto.Address;
import com.project.dto.Application;
import com.project.dto.Client;
import com.project.dto.Container;
import com.project.dto.LogisticCompany;
import com.project.dto.ResponseObject;
import com.project.dto.User;
import com.project.dto.*;

import com.project.repository.ClientDatabase;

import java.util.ArrayList;

public class Controller {
	
	static User activeUser;
	static LogisticCompany company;
	static Application app;
	
	
	static ChooseContainer chooseContainer = new ChooseContainer();
	static ClientJourney clientJourney = new ClientJourney();
	static ClientJourneyContainer_Details clientJourneyContainer_Details = new ClientJourneyContainer_Details();
	static ClientMainMenu clientMainMenu = new ClientMainMenu();
	static ClientProfile clientProfile = new ClientProfile();
	static ClientProfileEdit clientProfileEdit= new ClientProfileEdit();
	static ClientRegister clientRegister = new ClientRegister();
	static CompClients compClients;
	static CompJourneyContainer_Details compJourneyContainer_Details = new CompJourneyContainer_Details();
	static CompMainMenu compMainMenu = new CompMainMenu();
	static ContainerHistory containerHistory = new ContainerHistory();
	//static ContainerStorage containerStorage = new ContainerStorage();
	static JourneyRegister journeyRegister = new JourneyRegister();
	static LogIn logIn = new LogIn();
	static Warning saved = new Warning();
	static UpdateStatus updateStatus = new UpdateStatus();
	static Welcome welcome = new Welcome();
	

	
	static public void initialize() {
		//Import all the objects from SQL tables
		company = new LogisticCompany("Maersk","0000","details");
		company.getClientDatabase().registering(new Client("Harry", new Address("DK", "CPH", "2800", "Fysikvej", "200"), "Harry 2", "@dtu", "0000"));
		company.getClientDatabase().registering(new Client("Jo", new Address("DK", "CPH", "2800", "Fysikvej", "200"), "Harry 2", "@dtu", "0000"));

		Welcome.newScreen();
		
		company.getClientDatabase().findAll();
				


		//company.getClientDatabase().findAll();


	}
	
	
	public static class Requests{

		static ClientDatabase CDB = company.getClientDatabase();
		static ArrayList<Client> clients = CDB.getClients();
		static ArrayList<Container> containers = company.getContainerDatabase().getContainers();


		public static void closure() {


		}

		public static Object[][] tableClientSetter(String mode, String filter, String searchword) {

			Object[][] finalTable;

			if (mode.equals("all")){
				clients = CDB.getClients();
			}
			else if(mode.equals("filter")) {
				clients = CDB.searchClient(searchword, filter);
			}

			finalTable = new String[clients.size()][9];

			for (int i = 0; i<clients.size();i++) {
				finalTable[i][0] = clients.get(i).getClientID();
				finalTable[i][1] = clients.get(i).getName();
				finalTable[i][2] = clients.get(i).getAddress().getCountry();
				finalTable[i][3] = clients.get(i).getAddress().getCity();
				finalTable[i][4] = clients.get(i).getAddress().getPostcode();
				finalTable[i][5] = clients.get(i).getAddress().getStreetName();
				finalTable[i][6] = clients.get(i).getAddress().getStreetNumber();
				finalTable[i][7] = clients.get(i).getReferencePerson();
				finalTable[i][8] = clients.get(i).getEmail();

			}
			return finalTable;
		}
		
		public static Object[][] tableContainerSetter() {
			
			Object[][] finalTable;
			
				
				
			containers = company.getContainerDatabase().getContainers();
			
			
			finalTable = new String[containers.size()][6];
			
			for (int i = 0; i<clients.size();i++) {
				finalTable[i][0] = containers.get(i).getContainerID();
				finalTable[i][1] = containers.get(i).getCurrentPosition();
				finalTable[i][2] = containers.get(i).getTemperature().get(containers.get(i).getTemperature().size()-1);
				finalTable[i][3] = containers.get(i).getHumidity().get(containers.get(i).getHumidity().size()-1);
				finalTable[i][4] = containers.get(i).getPressure().get(containers.get(i).getPressure().size()-1);	
				if (containers.get(i).getInJourney()) {
					finalTable[i][5] = containers.get(i).getJourneys().get(containers.get(i).getJourneys().size() -1);
				}
				else {
					finalTable[i][5] = "No current journey.";
				}
				
			}
			return finalTable;
		}
		

		public static ResponseObject registerClient(String name, String country, String city, String postcode, String streetname, String streetnumber, String referenceperson, String email) {
			Address addr = new Address(country, city, postcode, streetname, streetnumber );

			Client cl = new Client(name, addr, referenceperson, email, "0000");
			ResponseObject response = CDB.registering(cl);

			return response;
		}

	
	}


	public static void main(String[] args) {
		initialize();
	}
	
	

	
	
}
