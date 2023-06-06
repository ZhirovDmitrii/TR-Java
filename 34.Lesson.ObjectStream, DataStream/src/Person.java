import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Person implements Serializable{
	int id;
	String name;
	Address address;
	LocalDate birthDate;
	
	public Person(int id, String name, Address address, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", birthDate=" + birthDate + "]";
	}
	
}


