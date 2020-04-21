package pro;

import java.util.ArrayList;

import pro.JourneyDatabase;

public class Journey {

// TF
public String OriginPort;
public String Destination;
public String Content;
public String Company;
public String JourneyID;
public ArrayList<String> Container;

public void updateJourney(String ID , JourneyDatabase j ) {
	if (j.listOfJourneys.contains(ID)) {
        // this method is for updating the current position
		// so we need a variable for position and put a scanner.
	}
	else {
		System.out.println("This ID was not found!");
	}
}
}
