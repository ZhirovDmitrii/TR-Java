
public class PerformanceTest {
	static int nConcat = 100_000;
	static String str = "ab";

	public static void main(String[] args) {
		// String Builder work time
		long start = System.currentTimeMillis();
		stringBuilderConcat(nConcat);
		long finish = System.currentTimeMillis();
		System.out.println(finish - start);
		
		// String work time
		start = System.currentTimeMillis();
		stringConcat(nConcat);
		finish = System.currentTimeMillis();
		System.out.println(finish - start);
	}

	public static String stringConcat(int count) {
		String res = "";

		while (count > 0) {
			res += str;
			count--;
		}
		return res;
	}

	public static String stringBuilderConcat(int count) {
		StringBuilder sb = new StringBuilder();

		while (count > 0) {
			sb.append(str);
			count--;
		}
		return sb.toString();
	}
}