import java.io.*;
import java.util.Arrays;


public class InputAppl {

	public static void main(String[] args) throws IOException {
		InputStream input = new FileInputStream("hello.txt");
		
//		System.out.println(input.read());
		
//		int c;
//		while((c = input.read()) > 0) {
//			System.out.printf("%c", c);
//		}
//		System.out.println();
		
//		System.out.println(input.read());	// return -1 - nothing read
		
//		byte[] buffer = new byte[input.available()];	// return file size
//		input.read(buffer);
//		System.out.println(new String(buffer));
		
		byte[] buffer = new byte[10];
		int countBytes = 0;
		String str = "";
		while((countBytes = input.read(buffer)) > 0) {
			System.out.println(countBytes);
//			str += new String(buffer);	// will be trash
			str += new String(Arrays.copyOf(buffer, countBytes));	// no trash
			System.out.println(str);
		}
		
		input.close();
	}

}
