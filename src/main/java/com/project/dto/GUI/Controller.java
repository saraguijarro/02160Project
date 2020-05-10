package com.project.dto.GUI;

import com.project.dto.*;
import com.project.repository.ClientDatabase;
import com.project.repository.ClientRepository;
import com.project.repository.ContainerDB;
import com.project.repository.JourneyDB;

import java.util.ArrayList;

public class Controller {
	
	static User activeUser;
	static LogisticCompany company;
	static Application app;
	
	
	
	static ChooseContainer chooseContainer;
	static ClientJourney clientJourney;
	static ClientJourneyContainer_Details clientJourneyContainer_Details;
	static ClientMainMenu clientMainMenu = new ClientMainMenu();
	static ClientProfile clientProfile;
	static ClientProfileEdit clientProfileEdit;
	static ClientRegister clientRegister = new ClientRegister();
	static CompClients compClients;
	static CompJourneyContainer_Details compJourneyContainer_Details;
	static CompMainMenu compMainMenu = new CompMainMenu();
	static ContainerHistory containerHistory;
	static ContainerStorage containerStorage;
	static JourneyRegister journeyRegister = new JourneyRegister();
	static LogIn logIn = new LogIn();
	static Warning saved = new Warning();
	static UpdateStatus updateStatus;
	static Welcome welcome = new Welcome();
	

	
	static public void initialize() {
		//Import all the objects from SQL tables
		company = new LogisticCompany("Maersk","0000","details");
		
		//Test data
		company.getClientDatabase().registering(new Client("Harry", new Address("DK", "CPH", "2800", "Fysikvej", "200"), "Harry 2", "@dtu", "0000"));
		company.getClientDatabase().registering(new Client("Jo", new Address("DK", "CPH", "2800", "Fysikvej", "200"), "Harry 2", "@dtu", "0000"));
		Container ct = new Container();
		ct.setContainerID("CON21");
		Container ct2 = new Container();
		ct2.setContainerID("CON22");
		ct2.getJourneyIDs().add("JOU000004");ct2.setInJourney(true);
		ct.getTemperature().add(22.5);ct.getHumidity().add(40.5);ct.getPressure().add(0.02);
		ct.getJourneyIDs().add("JOU000002");ct.setInJourney(true);
		Jou jo = new Jou();
		jo.setJourneyID("JOU000002");jo.setDestination("Hawai");jo.setCompany("Netto");jo.setContent("Bananas");jo.setOriginPort("BEY");
		jo.setContainerID("CON21");
		jo.setClientID(company.getClientDatabase().getClients().get(0).getClientID());
		Jou jo2 = new Jou();
		jo2.setJourneyID("JOU000004");jo2.setDestination("France");jo2.setCompany("Netto");jo2.setContent("Furniture");jo2.setOriginPort("BEY");
		jo2.setContainerID("CON24");
		jo2.setContainerID("CON22");
		jo2.setClientID(company.getClientDatabase().getClients().get(1).getClientID());

		company.getJourneyDatabase().getJourneys().add(jo);
		company.getJourneyDatabase().getJourneys().add(jo2);
		company.getContainerDatabase().getContainers().add(ct);
		company.getContainerDatabase().getContainers().add(ct2);

		Welcome.newScreen();
		
		company.getClientDatabase().findAll();
		company.getJourneyDatabase().findAll();
		company.getContainerDatabase().findAll();
	}
	
	
	public static class Requests{

		static ClientDatabase CDB = company.getClientDatabase();
		static ArrayList<Client> clients = CDB.getClients();
		static ContainerDB ContainerDatabase = company.getContainerDatabase();
		static ArrayList<Container> containers = ContainerDatabase.getContainers();
		static JourneyDB JourneyDatabase = company.getJourneyDatabase();
		static ArrayList<Jou> journeys = JourneyDatabase.getJourneys();
		



		public static void closure() {
			company.getClientDatabase().writeAllToDatabase();
			company.getContainerDatabase().writeAllToDatabase();
			company.getJourneyDatabase().writeAllToDatabase();

		}

		public static Object[][] tableClientSetter(String mode, String filter, String searchword) {

			Object[][] finalTable;

			if (mode.equals("all")){
				clients = CDB.getClients();
			}
			else if(mode.equals("filter")) {
				clients = CDB.searchClient(searchword, filter);
			}

			if (clients.size()==0) {
				finalTable = new String[9][1];
				finalTable[0][0]="";
				finalTable[1][0]="";
				finalTable[2][0]="";
				finalTable[3][0]="";
				finalTable[4][0]="";
				finalTable[5][0]="";	
				finalTable[6][0]="";
				finalTable[7][0]="";
				finalTable[8][0]="";
			}
			else {
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
			}
			return finalTable;
		}
		
		public static Object[][] tableHistorySetter(Container c) {

			Object[][] finalTable;

			
				finalTable = new String[c.getTemperature().size()][4];
				for (int i = 0; i<c.getTemperature().size();i++) {
					finalTable[i][0] = c.getJourneyIDs().get(i);
					finalTable[i][1] = Double.toString(c.getTemperature().get(i));
					finalTable[i][2] = Double.toString(c.getHumidity().get(i));
					finalTable[i][3] = Double.toString(c.getPressure().get(i));
					
	
				}
			
			return finalTable;
		}
		
		public static Object[][] tableContainerSetter(String mode, String portOfOrigin) {
			
			Object[][] finalTable;			
			
			containers = company.getContainerDatabase().getContainers();
			if (mode.equals("POO")) {
				containers = company.getContainerDatabase().availableContainerAt(portOfOrigin);
			}
			if (containers.size()==0) {
				finalTable = new String[1][6];
				
				finalTable[0][0]="";
				finalTable[0][1]="";
				finalTable[0][2]="";
				finalTable[0][3]="";
				finalTable[0][4]="";
				finalTable[0][5]="";
						
			}
			else{finalTable = new String[containers.size()][6];
			
				for (int i = 0; i<containers.size();i++) {
					finalTable[i][0] = containers.get(i).getContainerID();
					finalTable[i][1] = containers.get(i).getCurrentPosition();
					if(containers.get(i).getTemperature().size()>0) {finalTable[i][2] = Double.toString(containers.get(i).getTemperature().get(containers.get(i).getTemperature().size()-1));}
					if(containers.get(i).getHumidity().size()>0) {finalTable[i][3] = Double.toString(containers.get(i).getHumidity().get(containers.get(i).getHumidity().size()-1));}
					if(containers.get(i).getPressure().size()>0) {finalTable[i][4] = Double.toString(containers.get(i).getPressure().get(containers.get(i).getPressure().size()-1));}
					if (containers.get(i).getInJourney()) {
						finalTable[i][5] = containers.get(i).getJourneyIDs().get(containers.get(i).getJourneyIDs().size() -1);
					}
					else {
						finalTable[i][5] = "No current journey.";
					}
					
				}
			}
			return finalTable;
		}
		
public static Object[][] tableJourneySetter(String mode, String mode2, String filter, String searchword) {
			
	
			JourneyDB clientJourneys=new JourneyDB();
			Object[][] finalTable;
			
			if (mode2.equals("company")) {journeys = company.getJourneyDatabase().getJourneys();}
			else {journeys = company.getJourneyDatabase().searchJourney(((Client) activeUser).getClientID(), "Client");
				clientJourneys.setJourneys(journeys);
			}
			
			if (mode.equals("all")){
				journeys = journeys;
			}
			else if(mode.equals("filter")) {
				if (mode2.equals("company")) {journeys = JourneyDatabase.searchJourney(searchword, filter);}
				else {journeys = clientJourneys.searchJourney(searchword, filter);}
				
				
			}			
			
			if (journeys.size()==0) {
				finalTable = new String[1][7];
				
				finalTable[0][0]="";
				finalTable[0][1]="";
				finalTable[0][2]="";
				finalTable[0][3]="";
				finalTable[0][4]="";
				finalTable[0][5]="";
				finalTable[0][6]="";
						
			}
			else{finalTable = new String[journeys.size()][7];
			
				for (int i = 0; i<journeys.size();i++) {
					finalTable[i][0] = journeys.get(i).getJourneyID();
					finalTable[i][1] = journeys.get(i).getOriginPort();
					finalTable[i][2] = journeys.get(i).getDestination();
					finalTable[i][3] = journeys.get(i).getContent();
					finalTable[i][4] = journeys.get(i).getCompany();
					finalTable[i][5] = journeys.get(i).getContainerID();
					if (journeys.get(i).isOnGoing()) {finalTable[i][6] = "In Progress";}
					else {finalTable[i][6] = "Finished";}
					
					
				}
			}
			return finalTable;
		}
		

		public static ResponseObject registerClient(String name, String country, String city, String postcode, String streetname, String streetnumber, String referenceperson, String email) {
			Address addr = new Address(country, city, postcode, streetname, streetnumber );

			Client cl = new Client(name, addr, referenceperson, email, ClientRepository.hashString("0000"));
			ResponseObject response = CDB.registering(cl);

			return response;
		}

		public static ResponseObject ContainerUpdate(Container C, String temp, String hum, String press, String pos) {
			String updated = "Succesfully updated";
			double Temp;
			double Hum;
			double Press;
			Jou J;
			int counter=0;
			int code = 600;
			ResponseObject updatePosResponse = null;
			
			if (JourneyDatabase.getJourneys().size()>0){
				J=JourneyDatabase.find(C.getJourneyIDs().get(C.getJourneyIDs().size()-1));
			} else {J = new Jou();}
			
			try {Temp = Double.parseDouble(temp);updated = updated + ", Internal Temperature";
	            }
	        catch (Exception e) { 
	        	if (C.getTemperature().size()>0) {Temp = C.getTemperature().get(C.getTemperature().size()-1);}
	        	else{Temp = 0;}counter++;
	            } 
			try {  
	            Hum = Double.parseDouble(hum); 
	            updated = updated + ", Air Humidity";
	            }
	        catch (Exception e) { 
	        	if (C.getHumidity().size()>0){Hum = C.getHumidity().get(C.getHumidity().size()-1);}
	        	else{Hum = 0;}counter++;
	            } 
			try {  
	            Press = Double.parseDouble(press);
	            updated = updated + ", Atmospheric Pressure";
	            }
	        catch (Exception e) { 
	        	if (C.getPressure().size()>0) {Press = C.getPressure().get(C.getPressure().size()-1);}
	        	else{Press = 0;}counter++;
	            } 
			
			if (counter<3) {ResponseObject responseTrackAll = C.trackAll(Temp, Hum, Press);}
			
			if (pos.equals("")) {}	
			else {
				updatePosResponse = J.update(pos, ContainerDatabase);
				
				updated = updated + ", current position";
				if(updatePosResponse.getCode()==212) {
					updated = updated + ". Journey has reached its destination!";
				}
			}
			
			if(updated.equals("Succesfully updated") && pos.equals("")) {
				updated = "The update has failed! Incorrect or empty values";
				code = 604;
			}
			ResponseObject finalResponse = new ResponseObject(code, updated);
			
			
			
			
			return finalResponse;
		}
		
		public static ResponseObject updateClient(Client cl,
				String country, String city, String postcode, String streetname, String streetnumber,
				String email, String referenceperson, String password) {
			
			ResponseObject response = null;
			int counter = 0;
			String cou;
			String ci;
			String pos;
			String sname;
			String snumber;
				
			if (!(country.equals(""))){cou = country;} else {cou = cl.getAddress().getCountry(); counter++;} 
			if (!(city.equals(""))){ci = city;} else {ci = cl.getAddress().getCity(); counter++;} 
			if (!(postcode.equals(""))){pos = postcode;} else {pos = cl.getAddress().getPostcode(); counter++;} 
			if (!(streetname.equals(""))){sname = streetname;} else {sname = cl.getAddress().getStreetName(); counter++;} 
			if (!(streetnumber.equals(""))){snumber = streetnumber;} else {snumber = cl.getAddress().getStreetNumber(); counter++;} 
			if (counter<5) {cl.update("address2", new Address(cou,ci,pos,sname,snumber));}
			
			if (!(referenceperson.equals(""))){cl.update("reference person", referenceperson);} else {counter++;}
			if (!(email.equals(""))){cl.update("email", email);} else {counter++;}
			if (!(password.equals(""))){cl.update("password", password);} else {counter++;}
			
			if (counter == 8) {response = new ResponseObject(620, "No updates registered!");}
			else {response = new ResponseObject(622, "Information updated!");}


			
			return response;
		}

		public static ResponseObject register1Journey(String port, String destin, String cont,
				String comp) {
			String Port;
			String Destin;
			String Cont;
			String Comp;
			
			if(port.equals("")) {Port = null;}
			else {Port = port;}
			if(destin.equals("")) {Destin = null;}
			else {Destin = destin;}
			if(cont.equals("")) {Cont = null;}
			else {Cont = cont;}
			if(comp.equals("")) {Comp = null;}
			else {Comp = comp;}
			
			Jou journey = new Jou(Port, Destin, Cont, Comp);
			ResponseObject response1 = JourneyDatabase.registerStep1(journey);
				
			
			return response1;
		}

		public static void register2Journey(Jou j, Container c) {
			JourneyDatabase.registerStep2(j,c,(Client) activeUser, company);
			
		}
		

	
	}


	public static void main(String[] args) {

		initialize();
//		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//			company.getClientDatabase().writeAllToDatabase();
//			company.getContainerDatabase().writeAllToDatabase();
//			company.getJourneyDatabase().writeAllToDatabase();
//		}, "Shutdown-thread"));

	}
	
	

	
	
}
