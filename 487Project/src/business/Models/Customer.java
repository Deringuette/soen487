package business.Models;

public class Customer {
	
	private int customerReferenceNumber;
	private String name;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	public Customer(int customerReferenceNumber, String name, String street1, String street2, 
			String city, String state, String zip, String country){
		this.customerReferenceNumber = customerReferenceNumber;
		this.name = name;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		
	}

	public int getCustomerReferenceNumber() {
		return customerReferenceNumber;
	}

	public void setCustomerReferenceNumber(int customerReferenceNumber) {
		this.customerReferenceNumber = customerReferenceNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
