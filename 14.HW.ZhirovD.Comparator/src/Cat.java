//	Task 1
public class Cat implements Comparable<Cat> {
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

//	Task 2
	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public Integer getAge() {
		return age;
	}

	public Double getWeigth() {
		return weight;
	}

	@Override
	public int compareTo(Cat o) {
		int res = this.getName().compareTo(o.getName());

		if (res == 0) {
			res = this.getAge().compareTo(o.getAge());
			if (res == 0) {
				res = this.getWeigth().compareTo(o.getWeigth());
			}
		}
		return res;
	}

}