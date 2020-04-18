import java.util.ArrayList;

public class Container {
	
	boolean hasID;
	
	public boolean hasId(Container container) {
		return hasID;
	}
	
	int temperature;
	int humidity;
	int pressure;
	
	public void currentInternalStatus(int temperature, int humidity, int pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
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
	
	public modifyData update(String dataChoice, int updateData) {
		if (dataChoice.equals("temperature")) {this.setTemperature(updateData);}
		else if (dataChoice.equals("humidity")) {this.setHumidity(updateData);}
		else if (dataChoice.equals("pressure")) {this.setPressure(updateData);}
	}
	
	public void historyInternalStatus(int temperature, int humidity, int pressure) {
		
		ArrayList<Integer> InternalTemperature = new ArrayList<Integer>();
		InternalTemperature.add(this.temperature);
		
		ArrayList<Integer> AirHumidity = new ArrayList<Integer>();
		AirHumidity.add(this.humidity);
		
		ArrayList<Integer> AtmosphericPressure = new ArrayList<Integer>();
		AtmosphericPressure.add(this.pressure);
	}
	
	
	

		
	
}