package oop;

public class Animal {
	private String name;
	private int age;

	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String name, int age) {
		super();
		setName(name);
		if (age > 0 && age <= 120)
			this.age = age;
		else
			System.out.println("Wrong age");
	}

	public Animal(String alias) {
		super();
		name = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.equals("")) {
			System.out.println("Wrong name");
			this.name = "Unknown name";
		} else
			this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (this.age < age)
			this.age = age;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}

	public void voice()
	{
		System.out.println("Voice of animal");
	}
	
	public void voiceAnimal()
	{
		System.out.println("Voice of animal");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal))
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}