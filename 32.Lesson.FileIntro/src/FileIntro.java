import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class FileIntro {
	public static void main(String[] args) throws IOException {
		File node = new File("File");	// relative path
		File node01 = new File("C:/Users/zhiro/Documents/TR-Java/32.Lesson.FileIntro/file");	// absolute path
		
		System.out.println(node.exists()); 	// false now
		node.createNewFile();
		System.out.println(node.exists());	// true
		System.out.println();
		
		File node02 = new File("dir");
		node02.mkdir();					// create directory
		
		// opt 1
//		File node03 = new File("dir1/dir2/dir3");
		// opt 2
		File node03 = new File("dir1" + File.separator + "dir2" + File.separator + "dir3");
		node03.mkdirs();				// create directories
		
		File node04 = new File(node03, "file01");	// node03 - parent
		node04.createNewFile();			// inside dir3
		
//		node04.delete();	// delete file01
//		node03.delete();	// delete dir3
//		node03.delete();	// delete dir2
//		node03.delete();	// delete dir1
		
		System.out.println(node02.isDirectory());
		System.out.println(node02.isFile());
		System.out.println(node02.getAbsolutePath());
		System.out.println(node02.getPath());
		System.out.println(node04.getParent());
		System.out.println(node04.length());
		System.out.println(node04.canRead());	// false - can't read if not allowed
		System.out.println(node04.canWrite());	// false - can't write if not allowed
		node04.setWritable(true);
		node04.setReadable(true);
		System.out.println(node04.canRead());	// true
		System.out.println(node04.canWrite());	// true
		System.out.println();
		
		System.out.println(node04.getTotalSpace());	// byte
		System.out.println(node04.getFreeSpace());	// byte
		System.out.println();
		
		String[] array = node03.list();
		System.out.println(Arrays.toString(array));	// array all file names in directory
			
		printDir("file");	// file with name "file" inside
		printDir("dir1");	// dir2 inside
		printDir(".");
		System.out.println();
		printDir("..");		// up (1 lvl)
		System.out.println();
		printDir("../..");	// up up (2 lvl)
		System.out.println();
		
		Path path = node04.toPath();
		File file = path.toFile();
		
		Files.getLastModifiedTime(node04.toPath());
		
		System.out.println("Hello");	// 1 Channel
		System.err.println("Hello");	// 2 Channel
	}
	
	public static void printDir(String dirName) {
		File node = new File(dirName);
		if(!node.exists())
			throw new RuntimeException(dirName + "not found");
		if(node.isFile())
			System.out.println(node.getName() + " is file");
		else {
			String[] ar = node.list();
			for(String s: ar)
				System.out.println(s);
		}
	}

}
