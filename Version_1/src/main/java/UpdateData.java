public class UpdateData {

//code to update the current internal status of the container, instantaneous data
	
	int temperature;
	int humidity;
	int pressure;
	
	String remove = "";
	
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	
	public UpdateData update(String dataChoice, int updateData) {
		UpdateData modifyData = null;
		if (dataChoice.equals("temperature")) {this.setTemperature(updateData);}
		else if (dataChoice.equals("humidity")) {this.setHumidity(updateData);}
		else if (dataChoice.equals("pressure")) {this.setPressure(updateData);}
		return modifyData;
	}
	
	public UpdateData retrieve(String dataChoice) {
		UpdateData retrieveData = null;
		if (dataChoice.equals("temperature")) {remove = Integer.toString(this.temperature);}
		else if (dataChoice.equals("humidity")) {remove = Integer.toString(this.humidity);}
		else if (dataChoice.equals("pressure")) {remove = Integer.toString(this.pressure);}
		return retrieveData;
	}
	
//code to update the historical internal status of the container, track throughout time
	
	String location;
	
	public UpdateData track(String dataChoice) {
		UpdateData trackData = null;
		if (dataChoice.equals("temperature")) {InternalTemperature.add(temperature);}
		else if (dataChoice.equals("humidity")) {AirHumidity.add(humidity);}
		else if (dataChoice.equals("pressure")) {AtmosphericPressure.add(pressure);}
		return trackData;
	}
	
	public UpdateData locate(String journeyID) {
		UpdateData locateContainer = null;
		historyLocation.add(location);
		return locateContainer;
	}
	
}
