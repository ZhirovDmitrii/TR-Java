import java.io.*;

public class OutputAppl {

	public static void main(String[] args) throws IOException {
		OutputStream out = new FileOutputStream("hello.txt", true);
		
		// opt 1
		File file = new File("hello1.txt");
		OutputStream out1 = new FileOutputStream(file);
		out1.close();
		
		//opt 2
//		OutputStream out1 = new FileOutputStream(new File("hollo.txt"));
//		out1.close();
		
		String text = "Hello world";
		byte[] array = text.getBytes();	// cast to Byte
		out.write(array);
		out.close();
	}

}
