import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class PersonReadAppl {

	public static void main(String[] args) {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("persons.data"))){
			List<Person> res = (List<Person>) in.readObject();
			res.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
