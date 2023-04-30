
public class Person {
	int id;
	String name;
	Gender gender;
	public Person(int id, String name, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	public enum Gender{
		MALE, FEMALE, OTHER
	}
}
