
public class Address {

	String country;
	String city;
	String postcode;
	String streetName;
	String streetNumber;
	String keyWord;
	
	public Address(String country, String city, String postcode, String streetName, String streetNumber) {
		super();
		this.country = country;
		this.city = city;
		this.postcode = postcode;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.keyWord = "None";
	}

	public Address(String keyword) {
		this.keyWord = keyword;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
}
