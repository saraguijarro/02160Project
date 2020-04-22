
public class ContainerCurrent {
	
	int temperature;
	int humidity;
	int pressure;

	public ContainerCurrent(int temperature, int humidity, int pressure) {
		String[][] currentStatus = { { "Internal Temperature", Integer.toString(this.temperature) }, 
                					 { "Air Humidity", Integer.toString(this.humidity) }, 
                					 { "Atmospheric Pressure", Integer.toString(this.pressure) } }; 
		return;
	}
	
	
}
