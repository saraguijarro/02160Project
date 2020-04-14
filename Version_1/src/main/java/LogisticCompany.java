
public class LogisticCompany {
	
	String name;
	ClientDatabase clientDatabase;

	
	public LogisticCompany() {
		super();
		this.clientDatabase = new ClientDatabase();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClientDatabase getClientDatabase() {
		return clientDatabase;
	}

	public void setClientDatabase(ClientDatabase clientDatabase) {
		this.clientDatabase = clientDatabase;
	}
}
