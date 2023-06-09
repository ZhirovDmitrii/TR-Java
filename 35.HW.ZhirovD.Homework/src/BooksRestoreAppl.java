import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class BooksRestoreAppl {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.txt"))){
			List<Book> list = (List<Book>) ois.readObject();
			list.forEach(System.out::println);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
