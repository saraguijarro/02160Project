

import java.util.ArrayList;

public class Jou {
	
	public String OriginPort;
	public String Destination;
	public String Content;
	public String Company;
	public String JourneyID;
	public ArrayList<String> Container;

    public Jou(String op , String dest , String cont , String comp , String JID )	{
    	
    	this.OriginPort = op;
    	this.Destination = dest;
    	this.Content = cont;
    	this.Company = comp;
    	this.JourneyID = JID;
    	
    }

	public Jou() {
		super();
	}
	public String getOriginPort() {
		return OriginPort;
	}
	public void setOriginPort(String originPort) {
		OriginPort = originPort;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getJourneyID() {
		return JourneyID;
	}
	public void setJourneyID(String journeyID) {
		JourneyID = journeyID;
	}
	public ArrayList<String> getContainer() {
		return Container;
	}
	public void setContainer(ArrayList<String> container) {
		Container = container;
	}
	

	
}
