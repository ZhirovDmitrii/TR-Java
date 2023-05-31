import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyUtils {

	public static void copyFiles(String sourceFile, String destinationFile, byte[] bytes) throws IOException {
		try (InputStream in = new FileInputStream(sourceFile);
				OutputStream out = new FileOutputStream(destinationFile)) {

			int buffer;
			while ((buffer = in.read(bytes)) != -1)
				out.write(bytes, 0, buffer); // from arrayBytes, start = 0 element, to buffer
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createFileIfNotExist(String filePath) {
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkDestinationFile(File destinationFile, String[] args) {
		if (destinationFile.exists()) { // if true ->
			if (args.length >= 3 && args[2].equals("overwrite")) { // overwrite
				if (!destinationFile.delete()) { // if file deletion fails (false -> true)
					return false;
				}
			} else {
				return false; // can't overwrite
			}
		}
		return true;
	}

	public static void addTextToFile(String filePath, String text) throws IOException {
		@SuppressWarnings("resource")
		OutputStream out = new FileOutputStream(filePath);
		byte[] castToBytes = text.getBytes();
		out.write(castToBytes);
	}

}
