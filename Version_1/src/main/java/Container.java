import java.util.ArrayList;

public class Container {
	
	boolean hasID;
	
	public boolean hasId(Container container) {
		return hasID;
	}

//Code regarding the current internal status of the container, instantaneous data
	
	int temperature;
	int humidity;
	int pressure;
	
	public Container internalStatusCurrent(int temperature, int humidity, int pressure) {
		String[][] currentStatus = { { "Internal Temperature", Integer.toString(this.temperature) }, 
                					 { "Air Humidity", Integer.toString(this.humidity) }, 
                					 { "Atmospheric Pressure", Integer.toString(this.pressure) } }; 
		return null;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
		
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
		
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	
	public ResponseObject update(String updateChoice, int updateData) {
		ResponseObject modifyData = null;
		if (updateChoice.equals("temperature")) {this.setTemperature(updateData);}
		else if (updateChoice.equals("humidity")) {this.setHumidity(updateData);}
		else if (updateChoice.equals("pressure")) {this.setPressure(updateData);}
		return modifyData;
	}
	
	
//Code regarding the historical status of the container, track throughout time
	
	ArrayList<Integer> InternalTemperature;
	ArrayList<Integer> AirHumidity;
	ArrayList<Integer> AtmosphericPressure;
	
	String location;
	ArrayList<String> historyLocation = new ArrayList<String>();
	
	
	public Container internalStatusHistory(int temperature, int humidity, int pressure) {
		
		InternalTemperature = new ArrayList<Integer>();
		AirHumidity = new ArrayList<Integer>();
		AtmosphericPressure = new ArrayList<Integer>();
		
		InternalTemperature.add(this.temperature);
		AirHumidity.add(this.humidity);
		AtmosphericPressure.add(this.pressure);
		
		return null;
	}
		
	
	public ResponseObject track(String updateChoice) {
		ResponseObject trackData = null;
		if (updateChoice.equals("temperature")) {InternalTemperature.add(temperature);}
		else if (updateChoice.equals("humidity")) {AirHumidity.add(humidity);}
		else if (updateChoice.equals("pressure")) {AtmosphericPressure.add(pressure);}
		return trackData;
	}
		
	public ResponseObject locate(String journeyID) {
		ResponseObject locateContainer = null;
		historyLocation.add(location);
		return locateContainer;
	}
	
	
}
