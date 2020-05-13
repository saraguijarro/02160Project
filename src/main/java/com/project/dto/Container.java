package com.project.dto;

import com.project.repository.ContainerDB;

import java.util.ArrayList;

public class Container {
	
	private String currentPosition;
	private boolean inJourney;
	private String containerID;
	Jou journey;
	ArrayList<String> journeyIDs = new ArrayList<>();

	public ArrayList<String> getJourneyIDs() {
		return journeyIDs;
	}

	public void setJourneys(ArrayList<String> journeyIDs) {
		this.journeyIDs = journeyIDs;
	}

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
	
	private double temperature;
	private double humidity;
	private double pressure;


	public void setTemp(double temperature) {
		this.temperature = temperature;
	}
	public double getTemp() {
		return temperature;
	}
		
	public void setHum(double humidity) {
		this.humidity = humidity;
	}
	public double getHum() {
		return humidity;
	}
		
	public void setPress(double pressure) {
		this.pressure = pressure;
	}
	public double getPress() {
		return pressure;
	}
	
	public ResponseObject update(String updateChoice, double updateData) {
		
		ResponseObject modifyData = null;
		int code = 311;
		switch (updateChoice) {
			case "temperature":
				this.setTemp(updateData);
				code = 312;
				modifyData = new ResponseObject(code, "Measurement successfully added.");
				break;
			case "humidity":
				this.setHum(updateData);
				code = 313;
				modifyData = new ResponseObject(code, "Measurement successfully added.");
				break;
			case "pressure":
				this.setPress(updateData);
				code = 314;
				modifyData = new ResponseObject(code, "Measurement successfully added.");
				break;
		}
	
		if (code == 311) {modifyData = new ResponseObject(code, "Error, no measurement could be added.");}
		return modifyData;
	}
	
	
//Code regarding the historical status of the container, track throughout time
	
	ArrayList<Double> InternalTemperature = new ArrayList<>();
	ArrayList<Double> AirHumidity = new ArrayList<>();
	ArrayList<Double> AtmosphericPressure = new ArrayList<>();

	ArrayList<String> historyLocation = new ArrayList<>();


	public ArrayList<Double> getTemperature() {
		return InternalTemperature;
	}
	public void setTemperature(ArrayList<Double> InternalTemperature) {
		this.InternalTemperature = InternalTemperature;
	}
	
	public ArrayList<Double> getHumidity() {
		return AirHumidity;
	}
	public void setHumidity(ArrayList<Double> AirHumidity) {
		this.AirHumidity = AirHumidity;
	}
	
	public ArrayList<Double> getPressure() {
		return AtmosphericPressure;
	}
	public void setPressure(ArrayList<Double> AtmosphericPressure) {
		this.AtmosphericPressure = AtmosphericPressure;
	}
	
	public ResponseObject track(String updateChoice, double value) {
		
		ResponseObject trackData;
		int code = 321;
		switch (updateChoice) {
			case "temperature":
				InternalTemperature.add(value);
				code = 322;
				break;
			case "humidity":
				AirHumidity.add(value);
				code = 323;
				break;
			case "pressure":
				AtmosphericPressure.add(value);
				code = 324;
				break;
		}
		
		if (code != 321) {trackData = new ResponseObject(code, "Tracked internal status.");}
		else {trackData = new ResponseObject(code, "Error, could not track internal status.");}
		return trackData;
	}
		
	public ArrayList<String> getLocation() {
		return historyLocation;
	}
	public void setLocation(ArrayList<String> historyLocation) {
		this.historyLocation = historyLocation;
	}
	
	public ResponseObject locate(String location) {
		
		ResponseObject locateContainer;
		int code = 330;
		historyLocation.add(location);
		locateContainer = new ResponseObject(code, "Tracked location.");
		
		return locateContainer;
	}
	
	public ResponseObject trackAll(double tempValue, double humValue, double pressValue) {
		
		ResponseObject trackDataAll;
		int code = 350;
		InternalTemperature.add(tempValue);
		AirHumidity.add(humValue);
		AtmosphericPressure.add(pressValue);
		journeyIDs.add(journeyIDs.get(journeyIDs.size()-1));
		
		trackDataAll = new ResponseObject(code, "All tracked information have been successfully saved.");
		return trackDataAll;
	}
}
