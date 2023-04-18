package repeat;

public class Cat implements Comparable<Cat>{
	String name;
	String breed;
	Integer age;
	Double weight;
	
	public Cat(String name, String breed, Integer age, Double weight) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "NAME: " + name + ",\tBREED " + breed + ",\tAGE: " + age + ",\tWEIGHT: " + weight;
	}

	@Override
	public int compareTo(Cat o) {
		int res = name.compareTo(o.name);
		if(res == 0) {
			res = age.compareTo(o.age);
			if(res == 0) {
				res = weight.compareTo(o.weight);
			}
		}
		return res;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public Integer getAge() {
		return age;
	}

	public Double getWeight() {
		return weight;
	}	
	
	
}
