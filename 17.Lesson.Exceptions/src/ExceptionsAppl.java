import java.util.Scanner;

public class ExceptionsAppl {
//	try - catch
//	try - catches
//	try - finally
//	try - catch - finally
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Start");

		while (true) {
			try {
				System.out.println("enter number");
				String str = scanner.nextLine();
				int res = getNumber(str);
				System.out.println("number = " + res);
				try {

				} catch (Exception e2) {

				}
				break;

			} catch (IndexOutOfBoundsException e) {
				System.err.println("String must be entered");
			} catch (NumberFormatException | NullPointerException e) {
				System.err.println("String must be integer number");
				// args[0] = "1111";
				// int res = getNumber(args[0]);
				// System.out.println("number = " + res);
			} catch (Exception e) {
				System.out.println("catch worked");
				try {

				} catch (Exception e2) {

				}
			}
		}

		System.out.println(isNumber("111"));
		System.out.println(isNumber("111.1"));
		System.out.println(isNumber("aaaa"));
		System.out.println(isNumber(null));

		System.out.println("Finish");
	}

	public static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
//			finally
			return true;
		} catch (Exception e) {
//			finally
			System.out.println("message " + e.getMessage());
			System.out.println("stack " + e.getStackTrace());
			return false;
		} finally {
			System.out.println("finally");
		}
	}

	public static int getNumber(String str) {
		return Integer.parseInt(str);
	}
}