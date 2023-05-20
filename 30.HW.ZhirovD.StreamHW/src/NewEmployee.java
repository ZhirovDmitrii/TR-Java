
public class NewEmployee {
	public String name;
	public int salary;
	
	public NewEmployee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "NewEmployee [name=" + name + ", salary=" + salary + "]";
	}
	
	
}
