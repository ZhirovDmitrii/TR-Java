import java.util.Arrays;

public class SplitAppl {
	public static void main(String[] args) {
		String str = "    Two     beer or not     only two 			beer        ";
		String[] array = str.split(" ");
		System.out.println(Arrays.toString(array));

		array = str.trim().split("\\s+");
		System.out.println(Arrays.toString(array));
	}

}