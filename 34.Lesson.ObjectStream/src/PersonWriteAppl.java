
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonWriteAppl {

	public static void main(String[] args) {
		Person p = new Person(1, "Vasya", new Address("Haifa", "Hanita", 10), LocalDate.now());
		Child c = new Child(2, "Petya", new Address("Haifa", "Hanita", 10), LocalDate.now(), "Solnisko");
		Employee e = new Employee(3, "Masha", new Address("Haifa", "Hanita", 10), LocalDate.of(1980, 10, 10), "IBM",
				10000, "HR");

		ArrayList<Person> list = new ArrayList<>(Arrays.asList(p, c, e));

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("persons.data"))) {
			out.writeObject(list);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
