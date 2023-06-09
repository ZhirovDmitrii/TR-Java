package repeat1;

import java.util.Arrays;
import java.util.Set;

public class Programmer {
	int id;
	String name;
	Set<String> technology;
	int salary;
	
	public Programmer(int id, String name, String[] technology, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.technology.addAll(Arrays.asList(technology));
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Set<String> getTechnology() {
		return technology;
	}

	@Override
	public String toString() {
		return "Programmer [id=" + id + ", name=" + name + ", technology=" + technology + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programmer other = (Programmer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
