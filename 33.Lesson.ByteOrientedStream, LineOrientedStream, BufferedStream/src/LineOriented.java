import java.io.*;

public class LineOriented {

	public static void main(String[] args) throws IOException {
		Reader in = new FileReader("hello.txt");
		Writer out = new FileWriter("test.txt");
		
		int count;
		while((count = in.read()) > 0) {
			out.write(count);
		}
		
		in.close();
		out.close();
	}

}
