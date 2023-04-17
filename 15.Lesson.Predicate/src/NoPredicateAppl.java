import java.util.Arrays;

public class NoPredicateAppl {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		
		int[] oddNumbers = getOddNumbers(array);
		int[] evenNumbers = getEvenNumbers(array);
		int[] threeNumbers = getThreeNumbers(array);
		
		displayArray("odd numbers", oddNumbers);
		displayArray("even numbers", evenNumbers);
		displayArray("three numbers", threeNumbers);
	}

	private static int[] getThreeNumbers(int[] array) {
		int[] temp = Arrays.copyOf(array, array.length);
		int indexRes = 0;
		
		for(int i =0; i < temp.length;i++) {
			if(temp[i] % 3 == 0) {
				temp[indexRes++] = temp[i];
			}
		}
		return Arrays.copyOf(temp, indexRes);
	}

	private static int[] getEvenNumbers(int[] array) {
		int[] temp = Arrays.copyOf(array, array.length);
		int indexRes = 0;
		
		for(int i =0; i < temp.length;i++) {
			if(temp[i] % 2 == 0) {
				temp[indexRes++] = temp[i];
			}
		}
		return Arrays.copyOf(temp, indexRes);
	}

	private static int[] getOddNumbers(int[] array) {
		int[] temp = Arrays.copyOf(array, array.length);
		int indexRes = 0;
		
		for(int i =0; i < temp.length;i++) {
			if(temp[i] % 2 != 0) {
				temp[indexRes++] = temp[i];
			}
		}
		return Arrays.copyOf(temp, indexRes);
	}

	private static void displayArray(String string, int[] array) {
		System.out.println(string);
		System.out.println(Arrays.toString(array));
		System.out.println("********************");
		
	}

}