import java.util.ArrayList;

public class ContainerHistory {

	int temperature;
	int humidity;
	int pressure;
	String location;
	
	public ContainerHistory internalStatus(int temperature, int humidity, int pressure) {
		
		ArrayList<Integer> InternalTemperature = new ArrayList<Integer>();
		InternalTemperature.add(this.temperature);
		
		ArrayList<Integer> AirHumidity = new ArrayList<Integer>();
		AirHumidity.add(this.humidity);
		
		ArrayList<Integer> AtmosphericPressure = new ArrayList<Integer>();
		AtmosphericPressure.add(this.pressure);
		return null;
	}
}
