package com.project.dto;

public class Jou {
	
	Container c;



	public boolean onGoing = true;
	public String OriginPort;
	public String Destination;
	public String Content;
	public String Company;
	public String JourneyID;
	private Boolean hasID;

    public Jou(String op , String dest , String cont , String comp )	{
    	
    	this.OriginPort = op;
    	this.Destination = dest;
    	this.Content = cont;
    	this.Company = comp;
    	
    }

   
    
	public Jou() {
		super();
	}

	public boolean isOnGoing() {
		return onGoing;
	}
	public void setOnGoing(boolean onGoing) {
		this.onGoing = onGoing;
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

	public Boolean getHasID() {
		return hasID;
	}
	public void setHasID(Boolean hasID) {
		this.hasID = hasID;
	}

	public void setC(Container container) {
		this.c = container;
	}
	
	public Container getC() {
		return c;
	}
	//---------Update Journey Method:------------
		
		//updating any field with a string
		public ResponseObject update(String updateContent) {
			ResponseObject updateResponse = null;
			this.c.setCurrentPosition(updateContent);
			int code=211;
			
			
			updateResponse = new ResponseObject(code, "current position succesfully updated");
			if(c.getCurrentPosition().equals(getDestination())) {
				this.onGoing = false;
				updateResponse = new ResponseObject(code, "current position succesfully updated and the journey is terminated");
			}
			
			return updateResponse;
		}
		
	//------------end of Update current position method--------------

	//--isFound() method, used in the "searchingClient()" method from the ClientDatabase class
	//used to find if a substring can be found in the information of a client	
		public ResponseObject isFound(String searchword) {
			int code = 230;
			String message = "";
			
			if (this.OriginPort.toLowerCase().contains(searchword.toLowerCase())){code = 231; message="Port of origin";}
			else if(this.Destination.toLowerCase().contains(searchword)){code = 232; message="Destination";}
			else if(this.Content.toLowerCase().contains(searchword.toLowerCase())){code = 233; message="Content";}
			else if(this.Company.toLowerCase().contains(searchword.toLowerCase())){code = 234; message="Company";}
					
			ResponseObject isFoundResponse = new ResponseObject(code,message);
			return isFoundResponse;
		}
		
	
}