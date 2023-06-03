import java.io.*;

public class HomeworkAdvanced {
	final static byte[] arrayBytes = new byte[16777216]; // 16 MB

	public static void main(String[] args) throws IOException {
		if(args.length < 2){
            System.out.println("Provide the source file and destination file names");
            return;
        }
		
		String sourceFile = args[0];
		String destinationFile = args[1];
		
		// create files
		MyUtils.createFileIfNotExist(sourceFile);
		MyUtils.createFileIfNotExist(destinationFile);
		
		// add text to file for check
		MyUtils.addTextToFile(sourceFile, "Checking");
		
		// create destination for work with destinationFile
		File destination = new File(destinationFile);
		
		// check destination file
		if(!MyUtils.checkDestinationFile(destination, args)) {
			System.out.println("Can't overwrite destination file");
		    return;
		}
		
		try {
			long startTime = System.currentTimeMillis();
			
			MyUtils.copyFiles(sourceFile, destinationFile, arrayBytes);
			
			long fileSize = sourceFile.length();
			long endTime = System.currentTimeMillis();
			double bitrate = (double) fileSize / (endTime - startTime);
			
			System.out.printf("File has been copied with bitrate %.2f bytes per one millisecond.", bitrate);
		} catch (IOException e) {
			System.out.println("An exception occurred: " + e.getMessage());
		}
		
		
	}
}
