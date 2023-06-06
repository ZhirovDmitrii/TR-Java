import java.io.Serializable;

@SuppressWarnings("serial")
public class Address implements Serializable{
	String city;
	String street;
	int building;
	
	public Address(String city, String street, int building) {
		super();
		this.city = city;
		this.street = street;
		this.building = building;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", building=" + building + "]";
	}
	
	
}
