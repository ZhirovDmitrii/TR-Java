import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateAppl {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int[] oddNumbers = getNumbers(array, new OddNumbersPredicate());
		int[] evenNumbers = getNumbers(array, new EvenNumbersPredicate());
		int[] threeNumbers = getNumbers(array, new Divider3Predicate());
		
		// negate()
		int[] evenNumbers1 = getNumbers(array, new EvenNumbersPredicate().negate());

		// and()
		int[] oddNumbersDiv3 = getNumbers(array, new OddNumbersPredicate().and(new Divider3Predicate()));

		// or()
		int[] oddOrDiv3Numbers = getNumbers(array, new OddNumbersPredicate().or(new Divider3Predicate()));
		
		
		
		displayArray("odd numbers", oddNumbers);
		displayArray("even numbers", evenNumbers);
		displayArray("three numbers", threeNumbers);
		
		// negate()
		displayArray("even numbers1", evenNumbers1);
		
		// and()
		displayArray("odd three numbers", oddNumbersDiv3);
		
		// or()
		displayArray("odd or three numbers", oddOrDiv3Numbers);
	}

//	===========================================================
	private static int[] getNumbers(int[] array, Predicate<Integer> pred) {
		int[] temp = Arrays.copyOf(array, array.length);
		int indexRes = 0;

		for (int i = 0; i < temp.length; i++) {
			if (pred.test(temp[i]))
				temp[indexRes++] = temp[i];
		}

		return Arrays.copyOf(temp, indexRes);
	}

	private static void displayArray(String string, int[] array) {
		System.out.println(string);
		System.out.println(Arrays.toString(array));
		System.out.println("********************");
	}

}