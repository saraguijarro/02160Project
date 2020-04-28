package com.project.dto;

import java.util.ArrayList;

public class Container {
	
	boolean hasID;
	
	public boolean hasId(Container container) {
		return hasID;
	}

	boolean hasJourneyDB;
	
	public boolean hasJourneyDatabase(Container container) {
		return hasJourneyDB;
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
	/*
	public ResponseObject update(String updateChoice, int updateData) {
		
		ResponseObject modifyData = null;
		int code = 311;
		if (updateChoice.equals("temperature")) {this.setTemperature(updateData);}
		else if (updateChoice.equals("humidity")) {this.setHumidity(updateData);}
		else if (updateChoice.equals("pressure")) {this.setPressure(updateData);}
		return modifyData;
		
		if (code != 311) {
			if (updateChoice.equals("temperature")) {updateResponse = new ResponseObject(code, "Temperature successfully added.");}
			else if (updateChoice.equals("humidity")) {updateResponse = new ResponseObject(code, "Humidity successfully added.");}
			else if (updateChoice.equals("pressure")) {updateResponse = new ResponseObject(code, "Pressure successfully added.");}
		}
		return updateResponse;
	}*/
	
	
//Code regarding the historical status of the container, track throughout time
	
	ArrayList<Double> InternalTemperature;
	ArrayList<Double> AirHumidity;
	ArrayList<Double> AtmosphericPressure;
	
	String location;
	ArrayList<String> historyLocation = new ArrayList<String>();
	
	
	public Container internalStatusHistory(double temperature, double humidity, double pressure) {
		
		InternalTemperature = new ArrayList<Double>();
		AirHumidity = new ArrayList<Double>();
		AtmosphericPressure = new ArrayList<Double>();
		
		InternalTemperature.add(this.temperature);
		AirHumidity.add(this.humidity);
		AtmosphericPressure.add(this.pressure);
		return null;
	}
		
	/*
	public ResponseObject track(String updateChoice) {
		
		ResponseObject trackData = null;
		int code = 314;
		if (updateChoice.equals("temperature")) {InternalTemperature.add(temperature);}
		else if (updateChoice.equals("humidity")) {AirHumidity.add(humidity);}
		else if (updateChoice.equals("pressure")) {AtmosphericPressure.add(pressure);}
		return trackData;
		
		if (code != 314) {updateResponse = new ResponseObject(code, "Tracked internal status.");}
		return updateResponse;
	}
		
	public ResponseObject locate(String journeyID) {
		
		ResponseObject locateContainer = null;
		int code = 317;
		historyLocation.add(location);
		return locateContainer;
		
		if (code != 317) {updateResponse = new ResponseObject(code, "Tracked location.");}
		return updateResponse;
	}
	*/
	
}
