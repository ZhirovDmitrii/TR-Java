
public class MinMaxValues {

	public static void main(String[] args) {

		// Print min and max values all data types

		// byte
		System.out.println("Byte min value = " + getMinByteValue());
		System.out.println("Byte max value = " + getMaxByteValue());

		// short
		System.out.println("Short min value = " + getMinShortValue());
		System.out.println("Short max value = " + getMaxShortValue());

		// int
		System.out.println("Integer min value = " + getMinIntValue());
		System.out.println("Integer max value = " + getMaxIntValue());

		// long
		System.out.println("Long min value = " + getMinLongValue());
		System.out.println("Long max value = " + getMaxLongValue());

		// char
		System.out.println("Char min value = " + (int)getMinCharValue());
		System.out.println("Char max value = " + (int)getMaxCharValue());
	}

	private static byte getMinByteValue() {
		byte res = 1;
		while (res > 0) {
			res *= 2;
		}
		return (byte) (res);
	}

	private static byte getMaxByteValue() {
		byte res = 1;
		while (res > 0) {
			res *= 2;
		}
		return (byte) (res - 1);
	}

	private static short getMinShortValue() {
		short res = 1;
		while (res > 0) {
			res *= 2;
		}
		return (short) (res);
	}

	private static short getMaxShortValue() {
		short res = 1;
		while (res > 0) {
			res *= 2;
		}
		return (short) (res - 1);
	}

	private static int getMinIntValue() {
		int res = 1;
		while (res > 0) {
			res *= 2;
		}
		return res;
	}

	private static int getMaxIntValue() {
		int res = 1;
		while (res > 0) {
			res *= 2;
		}
		return res - 1;
	}

	private static long getMinLongValue() {
		long res = 1;
		while (res > 0) {
			res *= 2;
		}
		return res;
	}

	private static long getMaxLongValue() {
		long res = 1;
		while (res > 0) {
			res *= 2;
		}
		return res - 1;
	}

	private static char getMinCharValue() {
		char res = 1;
		while (res > 0)
		{
			res += (char) 1;
		}
		return res;
	}

	private static char getMaxCharValue() {
		char res = (char) - 1;
		return res;
	}

}