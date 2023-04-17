
public class RangeAppl {
	private static final int MIN_RANGE = 100;
	private static final int MAX_RANGE = 1000;
	private static final int N_NUMBERS = 10000;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 1100;

	public static void main(String[] args) {
		Range range = null;
		int countRight = 0;
		int countLess = 0;
		int countMore = 0;

		try {
			range = new Range(MIN_RANGE, MAX_RANGE);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < N_NUMBERS; i++) {
			int number = (int) (MIN_NUMBER + Math.random() * (MAX_NUMBER - MIN_NUMBER + 1));
			try {
				range.checkNumber(number);
				countRight++;
			} catch (NumberLessMinException e) {
				countLess++;
			} catch (NumberGreaterMaxException e) {
				countMore++;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.printf("Count right = %d, count less = %d, count great = %d", countRight, countLess, countMore);
	}
}