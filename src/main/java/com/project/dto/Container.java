package com.project.dto;

import java.util.ArrayList;

import com.project.repository.ContainerDB;

public class Container {
	
	private String currentPosition;
	private boolean inJourney;
	boolean hasID;
	String containerID;
	Jou journey;
	
	public Container() {
		super();
	}
	
	public Container(ContainerDB CDB , String cp) {
    	this.inJourney = false;
		this.currentPosition=cp;
	}
	
	public Container(boolean inJourney, String containerID) {
		super();
		this.inJourney = inJourney;
		this.containerID = containerID;
	}
	
	public Container(String containerID) {
		this.containerID = containerID;
	}

	public boolean hasId(Container container) {
		return hasID;
	}

	
	public void setContainerID(String containerID) {
		this.containerID = containerID;
	}
	
	public String getContainerID() {
		return containerID;
	}
	
	public boolean getInJourney() {
		return inJourney;
	}
	
	public void setInJourney(boolean inJourney) {
		this.inJourney = inJourney;
	}
	
	public String getCurrentPosition() {
		return currentPosition;
	}
	
	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	public Jou getJourney() {
		return journey;
	}

	public void setJourney(Jou journey) {
		this.journey = journey;
	}


//Code regarding the current internal status of the container, instantaneous data
	
	double temperature;
	double humidity;
	double pressure;
	
	String[][] currentStatus = new String[2][2];
	
	public Container internalStatusCurrent(int temperature, int humidity, int pressure) {
		String[][] currentStatus = { { "Internal Temperature", Double.toString(this.temperature) }, 
                					 { "Air Humidity", Double.toString(this.humidity) }, 
                					 { "Atmospheric Pressure", Double.toString(this.pressure) } }; 
		return null;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
		
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
		
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	
	
	public ResponseObject update(String updateChoice, double updateData) {
		
		ResponseObject modifyData = null;
		int code = 311;
		if (updateChoice.equals("temperature")) {
			this.setTemperature(updateData);
			code = 312;
			modifyData = new ResponseObject(code, "Temperature successfully added.");
		}
		
		else if (updateChoice.equals("humidity")) {
			this.setHumidity(updateData);
			code = 313;
			modifyData = new ResponseObject(code, "Humidity successfully added.");
		}

		else if (updateChoice.equals("pressure")) {
			this.setPressure(updateData);
			code = 314;
			modifyData = new ResponseObject(code, "Pressure successfully added.");
		}
	
		if (code == 311) {modifyData = new ResponseObject(code, "Error, no measurement could be added.");}
		return modifyData;
	}
	
	
//Code regarding the historical status of the container, track throughout time
	
	ArrayList<Double> InternalTemperature = new ArrayList<Double>();
	ArrayList<Double> AirHumidity = new ArrayList<Double>();
	ArrayList<Double> AtmosphericPressure = new ArrayList<Double>();
	
	String location;
	ArrayList<String> historyLocation = new ArrayList<String>();
	
	
	public Container internalStatusHistory(double temperature, double humidity, double pressure) {
		InternalTemperature.add(this.temperature);
		AirHumidity.add(this.humidity);
		AtmosphericPressure.add(this.pressure);
		return null;
	}
		
	
	public ResponseObject track(String updateChoice, double value) {
		
		ResponseObject trackData = null;
		int code = 321;
		if (updateChoice.equals("temperature")) {InternalTemperature.add(value);code = 322;}
		else if (updateChoice.equals("humidity")) {AirHumidity.add(value);code = 323;}
		else if (updateChoice.equals("pressure")) {AtmosphericPressure.add(value);code = 324;}
		
		if (code != 321) {trackData = new ResponseObject(code, "Tracked internal status.");}
		else {trackData = new ResponseObject(code, "Error, could not track internal status.");}
		return trackData;
	}
		
	public ResponseObject locate(Container container) {
		
		ResponseObject locateContainer = null;
		int code = 330;
		historyLocation.add(location);
		locateContainer = new ResponseObject(code, "Tracked location.");
		
		return locateContainer;
	}

	
}
