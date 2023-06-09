
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class PersonWriteAppl {
	private static final long N_PERSONS = 100;
	private static final int EML_PROBABILITY = 40;	// synonym word 'chance'
	private static final int MIN_CHILD_YEAR = 2005;
	private static final int MAX_CHILD_YEAR = 2023;
	private static final int N_GARTENS = 5;
	private static final int N_CITIES = 3;
	private static final int MIN_EMP_YEAR = 1950;
	private static final int MAX_EMP_YEAR = 2004;
	private static final int N_COMPANIES = 5;
	private static final int MIN_SALARY = 5000;
	private static final int MAX_SALARY = 100_000;
	
	private static final Random gen = new Random();
	static int counter = 1;
	static String[] titles = {"WageManager", "SaleManager", "Manager", "Accountant"};
	
	public static void main(String[] args) {
		List<Person> list = getRandomPersons();

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("persons.data"))) {
			out.writeObject(list);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// generate random Persons
	private static List<Person> getRandomPersons() {
						// PersonWriteAppl.getRandomPerson()
		return Stream.generate(() -> getRandomPerson()).limit(N_PERSONS).toList();
	}

	// create one random Person
	private static Person getRandomPerson() {
		Person p = getRandomCommonPerson();
		
		return getRandonNumber(1,100) <= EML_PROBABILITY ? getRandomEmployee(p) : getRandomChild(p);
	}

	// Generate random Child
	private static Person getRandomChild(Person p) {
		LocalDate birthDate = getRandomBirthdate(MIN_CHILD_YEAR, MAX_CHILD_YEAR);
		String garten = "garten" + getRandonNumber(1, N_GARTENS);
		return new Child(p.id, p.name, p.address, birthDate, garten);
	}

	// Generate random Employee
	private static Person getRandomEmployee(Person p) {
		LocalDate birthDate = getRandomBirthdate(MIN_EMP_YEAR, MAX_EMP_YEAR);
		String company = "company" + getRandonNumber(1, N_COMPANIES);
		int salary = getRandonNumber(MIN_SALARY, MAX_SALARY);
		String title = titles[getRandonNumber(0, titles.length-1)];
		
		return new Employee(p.id, p.name, p.address, birthDate, company, salary, title);
	}

	// Generate random birth date
	private static LocalDate getRandomBirthdate(int min, int max) {
		int year = getRandonNumber(min, max);
		int month = getRandonNumber(1, 12);
		int day = getRandonNumber(1, 28);
		return LocalDate.of(year, month, day);
	}

	// Generate random Person arguments
	private static Person getRandomCommonPerson() {
		int id = counter++;
		String name = "name" + getRandonNumber(1, 50);
		Address adress = getRandomAdress();
		
		return new Person(id, name, adress, null);
	}

	// generate random Address
	private static Address getRandomAdress() {
		String city = "city" + getRandonNumber(1, N_CITIES);
		String street = "street" + getRandonNumber(1, 50);
		int building = getRandonNumber(1, 10_000);
		
		return new Address(city, street, building);
	}

	// Generate random number from min to max
	private static int getRandonNumber(int min, int max) {
		return gen.ints(min, max+1).findAny().getAsInt();
	}

}
