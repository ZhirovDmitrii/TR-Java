import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyUtils {
	
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

	public static void copyFiles(File sourceFile, File destinationFile, byte[] bytes) throws IOException {
		
		try (InputStream in = new FileInputStream(sourceFile);
				OutputStream out = new FileOutputStream(destinationFile, true)) {

			int nBytes = 0;
			while ((nBytes = in.read(bytes)) > 0)
				out.write(bytes, 0, nBytes); // from arrayBytes, start = 0 element, to buffer
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkDestinationFile(File destinationFile, String[] args) {
		if(destinationFile.exists() && (args.length < 3 || !args[2].equalsIgnoreCase("overwrite"))) {
			System.out.println(args[1] + " can't be overwritten");
			return false;
		}
		return true;
	}

}
