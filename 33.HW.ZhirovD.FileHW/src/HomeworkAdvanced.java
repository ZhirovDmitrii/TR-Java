import java.io.*;

public class HomeworkAdvanced {
	final static byte[] arrayBytes = new byte[16777216]; // 16 MB

	public static void main(String[] args) throws IOException {
		if (args.length < 2 || args.length > 3) {
			System.out.println("Provide the source file and destination file names");
			return;
		}

		MyUtils.createFileIfNotExist(args[0]);
		MyUtils.createFileIfNotExist(args[1]);

		File sourceFile = new File(args[0]);
		File destinationFile = new File(args[1]);

		MyUtils.checkDestinationFile(destinationFile, args);

		try {
			long startTime = System.currentTimeMillis();

			MyUtils.copyFiles(sourceFile, destinationFile, arrayBytes);

			long sourceFileSize = args[0].length();
			long endTime = System.currentTimeMillis();
			double bitrate = (double) sourceFileSize / (endTime - startTime);

			System.out.printf("File has been copied with bitrate %.2f bytes per one millisecond.", bitrate);
		} catch (Exception e) {

		}
	}
}
