import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonAppl {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>(Arrays.asList(
				new Person("1", 1), 
				new Person("2", 2), 
				new Person("3", 3)));
//		System.out.println(findByAge(list, 1).name);
//		System.out.println(findByAge(list, 10).name);
		Person p = findByAge(list, 1).get();
		System.out.println(p.name);
		
		// argument 10 not exist
//		p = findByAge(list, 10).get();	 - exception
//		System.out.println(p.name);		 - exception
		Optional<Person> res = findByAge(list, 10);
		if(res.isPresent()) {
			Person p1 = res.get();
			System.out.println(p1.name);
		}
		res.ifPresent(p1 -> System.out.println(p1.name));
		System.out.println(res);
		
		p = res.orElse(new Person("anonimous", 120));
		System.out.println(p);
		
		p = res.orElseGet(() -> new Person("anonimous", 120));
		System.out.println(p);
		
//		p = res.orElseThrow(() -> new IllegalArgumentException());
		p = res.orElseThrow(IllegalArgumentException::new);	// new option
		System.out.println(p);
	}
	
	public static Optional<Person> findByAge(List<Person> list, int age) {
		Person res = null;
		for(Person p: list) {
			if(p.age == age) {
				res = p;
				break;
			}
		}
		return Optional.ofNullable(res);
	}

}
