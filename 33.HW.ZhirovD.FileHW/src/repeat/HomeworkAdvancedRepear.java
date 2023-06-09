package repeat;

import java.io.File;
import java.io.IOException;

public class HomeworkAdvancedRepear {

	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Source file or destination file not specified");
			return;
		}

		File source = new File(args[0]);
		File destination = new File(args[1]);

		if (source.exists()) {
			if (args.length == 3 && args[2].equalsIgnoreCase("Overwrite")) {
				long startTime = System.currentTimeMillis();
				
				HomeworkRepeat.copyFile(source, destination);
				
				long sourceFileSize = args[0].length();
				long endTime = System.currentTimeMillis();
				double bitrate = (double) sourceFileSize / (endTime - startTime);
				
				System.out.printf("File has been copied with bitrate %.2f bytes per one millisecond", bitrate);
			} else {
				System.out.println("Can't overwrite destination file");
				return;
			}
		} else {
			System.out.println("No source file");
			return;
		}
	}
}
