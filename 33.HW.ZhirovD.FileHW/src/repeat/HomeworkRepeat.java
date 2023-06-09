package repeat;

import java.io.*;

public class HomeworkRepeat {

	public static void main(String[] args) throws IOException {
		File source = new File("C:\\Users\\zhiro\\Documents\\TR-Java\\33.HW.ZhirovD.FileHW\\src\\repeat\\sourceFileR.txt");
		File destination = new File("C:\\Users\\zhiro\\Documents\\TR-Java\\33.HW.ZhirovD.FileHW\\src\\repeat\\destinationFileR.txt");

		copyFile(source, destination);
	}

	public static void copyFile(File source, File destination) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(destination, true);

			byte[] size = new byte[16777216]; // 16 MB
			int buffer;

			while ((buffer = is.read(size)) > 0) {
				os.write(size, 0, buffer);
			}
			System.out.println("File copied successfully");
		} catch (IOException e) {
			throw new IOException("Copy Error");
		} finally {
			is.close();
			os.close();
		}
	}
}
