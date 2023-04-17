import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SelectorPhotoTest {
//	Full list of picture file Names for selection in format:
//	folder\\YYYYMMDD_hhmmss.ext, where:
//	folder - name of folder equal to location where picture was taken
//	YYYY, MM, DD - year, month, day
//	hh,mm,ss - hours, minutes, seconds

	private static final String[] pictures = { "Paris\\20140101_090000.jpg", 
			"Paris\\20140201_121005.jpg",
			"Paris\\20150301_211035.jpg", 
			"Paris\\20150401_110023.gif", 
			"Paris\\20150401_181705.jpg",
			"Paris\\20150501_231035.gif", 
			"London\\20140205_090000.jpg", 
			"London\\20140205_121005.jpg",
			"London\\20140601_211035.gif", 
			"London\\20151001_110023.jpg", 
			"London\\20151001_121705.jpg",
			"London\\20151001_231035.jpg", 
			"Chicago\\20150301_120001.png", 
			"Chicago\\20151111_232000.png" };

	@Test
	void testAllParisLondonPictures() {
		String regex = "London|Paris";
		String[] actual = SelectorPhoto.selectPictures(pictures, regex);

		String[] expected = { "Paris\\20140101_090000.jpg", 
				"Paris\\20140201_121005.jpg",
				"Paris\\20150301_211035.jpg",
				"Paris\\20150401_110023.gif", 
				"Paris\\20150401_181705.jpg", 
				"Paris\\20150501_231035.gif",
				"London\\20140205_090000.jpg", 
				"London\\20140205_121005.jpg", 
				"London\\20140601_211035.gif",
				"London\\20151001_110023.jpg", 
				"London\\20151001_121705.jpg", 
				"London\\20151001_231035.jpg" };

		assertArrayEquals(expected, actual);
	}

	@Test
	void testAllAutumnPictures() {
		String regex = "\\d{4}(09|1[01])\\d{2}_";
		String[] actual = SelectorPhoto.selectPictures(pictures, regex);
		String[] expected = {"London\\20151001_110023.jpg", 
				"London\\20151001_121705.jpg",
				"London\\20151001_231035.jpg",
				"Chicago\\20151111_232000.png" };
		
		assertArrayEquals(expected, actual);
	}

	@Test
	void testAll2015SpringPictures() {
		String regex = "2015(0[345])\\d{2}_";
		String[] actual = SelectorPhoto.selectPictures(pictures, regex);
		String[] expected = {"Paris\\20150301_211035.jpg", 
				"Paris\\20150401_110023.gif", 
				"Paris\\20150401_181705.jpg",
				"Paris\\20150501_231035.gif",
				"Chicago\\20150301_120001.png" };
		
		assertArrayEquals(expected, actual);
	}

	@Test
	// from 18:00 to 00:00
	void testAllNightPictures(){
		String regex = "_(1[89]|2[0123]|00)\\d{4}";
		String[] actual = SelectorPhoto.selectPictures(pictures, regex);
		String[] expected = {"Paris\\20150301_211035.jpg",
				"Paris\\20150401_181705.jpg",
				"Paris\\20150501_231035.gif",
				"London\\20140601_211035.gif",
				"London\\20151001_231035.jpg",
				"Chicago\\20151111_232000.png" };
		
		assertArrayEquals(expected, actual);
	}

	@Test
	// from 18:00 to 00:00
	void testAllNightPicturesFromChicago(){
		String regex = "Chicago.*_(1[89]|2[0123]|00)\\d{4}";
		String[] actual = SelectorPhoto.selectPictures(pictures, regex);
		String[] expected = {
				"Chicago\\20151111_232000.png" };
		
		assertArrayEquals(expected, actual);
	}

	@Test
	void testAllJpgAndPngPictures() {
		String regex = "\\.(jpg|png)";
		String[] actual = SelectorPhoto.selectPictures(pictures, regex);
		String[] expected = {"Paris\\20140101_090000.jpg", 
				"Paris\\20140201_121005.jpg",
				"Paris\\20150301_211035.jpg",
				"Paris\\20150401_181705.jpg",
				"London\\20140205_090000.jpg", 
				"London\\20140205_121005.jpg",
				"London\\20151001_110023.jpg", 
				"London\\20151001_121705.jpg",
				"London\\20151001_231035.jpg", 
				"Chicago\\20150301_120001.png", 
				"Chicago\\20151111_232000.png" };
		
		assertArrayEquals(expected, actual);
	}
}
