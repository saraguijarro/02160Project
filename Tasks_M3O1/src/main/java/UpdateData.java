
public class UpdateData {

	int measurement;
	
	public int getMeasurement() {
		return measurement;
	}

	public UpdateData(int measurement) {
		this.measurement = measurement;
	}
	
	public RetrieveData(int measurement) {
		String remove = Integer.toString(measurement);
		remove = "";
	}
}
