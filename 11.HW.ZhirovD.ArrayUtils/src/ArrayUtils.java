import java.util.Arrays;

public class ArrayUtils {

	public static int[] add(int[] array, int i) {
		int[] res = new int[array.length + 1]; // {0,0,0,0}
		System.arraycopy(array, 0, res, 0, res.length - 1); // {1,2,3,0}
		res[res.length - 1] = i; // {1,2,3,4}
		return res;
	}

	public static int[] remove(int[] ar) {
		int[] res = Arrays.copyOf(ar, ar.length - 1); // res = ar - last index
		return res;
	}

	public static int[] remove(int[] ar, int index) {
		if (index < 0 || index >= ar.length || ar == null)
			return ar;

		int[] res = new int[ar.length - 1];

		// Option 1
		for (int i = 0, key = 0; i < ar.length; i++) {
			if (i == index)
				continue;
			res[key++] = ar[i];
		}
		

		// Option 2
//		System.arraycopy(ar, 0, res, 0, index);
//		System.arraycopy(ar, index+1, res, index, ar.length-index-1);

		return res;
	}

	public static Integer matrixSum(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				sum += matrix[i][j];
			}
		}
		return sum;
	}

	public static int[][] addColumn(int[][] matrix, int index, int[] columnElements)
	{
		int res[][] = new int[matrix.length + 1][];	//{} {} {}
		
		System.arraycopy(matrix, 0, res, 0, index);	// {1} {} {}
		res[index] = columnElements;				// {1} {2} {}
		System.arraycopy(matrix, index, res, index + 1, matrix.length-index); // {1} {2} {3}
		
		return res;
	}
	
	public static int[][] removeColumn(int[][] matrix, int index) {
		int[][] res = new int[matrix.length - 1][];	// {} {}
		
		System.arraycopy(matrix, 0, res, 0, index);	// {1} {}
		System.arraycopy(matrix, index+1, res, index, res.length-index);	// {1} {2}
		
		return res;
	}

	public static int[][] removeRow(int[][] matrix, int index) {
		int[][] res = new int[matrix.length][];
		for (int i = 0; i < res.length; i++) {
			res[i] = remove(matrix[i], index);
		}
		return res;
	}

	// =========================================================================================//
	public static int[][] addRow(int[][] matrix, int[] row, int index) {
		if (row.length != matrix.length || index < 0 || index > matrix[0].length)
			return null;

		int[][] res = new int[matrix.length][];
		for (int i = 0; i < res.length; i++) {
			res[i] = add(matrix[i], index, row[i]);
		}
		return res;
	}

	public static int[] add(int[] array, int index, int element) {
		int[] res = new int[array.length + 1]; // create new array + 1 length {0,0,0,0,0,0}
		System.arraycopy(array, 0, res, 0, index); // index - this is length {1,2,0,0,0,0}
		res[index] = element; // {1,2,10,0,0,0}
		System.arraycopy(array, index, res, index + 1, array.length - index); // {1,2,10, 3,4,5}
		return res;
	}

}