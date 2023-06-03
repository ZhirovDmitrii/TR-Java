import java.io.*;

public class Homework {
	final static byte[] arrayBytes = new byte[16777216]; // 16 MB
	final static String sourceFile = "sourceFile.txt";
	final static String destinationFile = "destinationFile.txt";

	public static void main(String[] args) throws IOException {
		MyUtils.createFileIfNotExist(sourceFile);
		MyUtils.createFileIfNotExist(destinationFile);
		
		File source = new File(sourceFile);
		File destination = new File(destinationFile);
		
		try {
			MyUtils.copyFiles(source, destination, arrayBytes);
			System.out.println("File copy");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not copy");
		}
	}
}
