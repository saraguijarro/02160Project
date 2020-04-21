package pro;
import java.util.ArrayList;
import java.util.Scanner;

import pro.Journey;

public class JourneyDatabase {
	
	public JourneyDatabase() {
		super();
		listOfJourneys = new ArrayList<Journey>();
	}

public int id = 0;
public int i;
public ArrayList<Journey> listOfJourneys;

public String findJourneydp(Journey dp) {
	if (dp.equals(dp.OriginPort)){
	return dp.JourneyID;
}
	else {
		return "No such Origin port found";
	}
}
public String findJourneyd(Journey d) {
	if (d.equals(d.Destination)){
	return d.JourneyID;
}
	else {
		return "No such destination found";
	}
}
public String findJourneyc(Journey c) {
	if (c.equals(c.Content)) {
	return c.JourneyID;
}
	else {
		return "No such content found";
	}
}

public String findJourney(Journey J) {
	return J.JourneyID;
}

public void registerJourney(Journey j) {
	Scanner x = new Scanner(System.in);
	
	System.out.println("Enter Company name:");
	j.Company = x.nextLine();
	
	System.out.println("Enter port of origin:");
	j.OriginPort = x.nextLine();
	
	System.out.println("Enter port of destination:");
	j.Destination = x.nextLine();
	
	System.out.println("Enter the content  (Optional):");
	j.Content = x.nextLine();
}
public void giveID(Journey journey) {
	String prefix = "JOU";
	String number = Integer.toString(this.listOfJourneys.size());
	String zeroes = "0".repeat(6-number.length());
	String id = prefix + zeroes + number;
	journey.JourneyID = id;
	
}
}
