package repeat;

public class ArrayUtils {
	
	public static int[] add(int[] array, int i) {
		int[] res = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, array.length);
		res[res.length-1] = i;
		return res;
	}
	
	public static int[] add(int[] array, int index, int element) {
		int[] res = new int[array.length + 1]; // create new array + 1 length {0,0,0,0,0,0}
		System.arraycopy(array, 0, res, 0, index); // index - this is length {1,2,0,0,0,0}
		res[index] = element; // {1,2,10,0,0,0}
		System.arraycopy(array, index, res, index + 1, array.length - index); // {1,2,10, 3,4,5}
		return res;
	}

	public static int[] remove(int[] ar) {
		int[] res = new int[ar.length - 1];
		System.arraycopy(ar, 0, res, 0, res.length);
		return res;
	}

	public static int[] remove(int[] ar, int i) {
		int[] res = new int[ar.length - 1];
		System.arraycopy(ar, 0, res, 0, i);
		System.arraycopy(ar, i+1, res, i, ar.length - 1 - i);
		return res;
	}

	public static Integer matrixSum(int[][] matrix) {
		int sum = 0;
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length; j++)
				sum += matrix[i][j];
		return sum;
	}
	
	public static int[][] addRow(int[][] matrix, int[] row, int index) {
		if (row.length != matrix.length || index < 0 || index > matrix[0].length)
			return null;

		int[][] res = new int[matrix.length][];
		for (int i = 0; i < res.length; i++) {
			res[i] = add(matrix[i], index, row[i]);
		}
		return res;
	}

	public static int[][] addColumn(int[][] matrix, int i, int[] rowElements) {
		int[][] res = new int[matrix.length + 1][];
		System.arraycopy(matrix, 0, res, 0, i);
		res[i] = rowElements;
		System.arraycopy(matrix, i, res, i+ 1, res.length - i - 1);
		return res;
	}

	public static int[][] removeRow(int[][] matrix, int index) {
		int[][] res = new int[matrix.length][];
		for (int i = 0; i < res.length; i++) {
			res[i] = remove(matrix[i], index);
		}
		return res;
	}

	public static int[][] removeColumn(int[][] matrix, int i) {
		int[][] res = new int[matrix.length - 1][];
		System.arraycopy(matrix, 0, res, 0, i);
		System.arraycopy(matrix, i+1, res, i, matrix.length - 1 - i);
		return res;
	}
}
