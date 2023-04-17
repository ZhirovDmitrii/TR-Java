
public class ArraysMatrix {
	// transposition matrix
	// 1 3 -> 1 2
	// 2 4 3 4

	public static int[][] transp(int[][] matrix) {
		int[][] res = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				res[j][i] = matrix[i][j];
			}
		}
		return res;
	}

	public static int[][] addRow(int[][] matrix, int[] row, int index) {
		if (row.length != matrix.length || index < 0 || index > matrix[0].length)
			return null;
//							   array size   array length
		int[][] res = new int[matrix.length][];
		for (int i = 0; i < res.length; i++) {
			res[i] = add(matrix[i], index, row[i]);
		}
		return res;
	}

													//{1,2,3,4,5} -> {1,2,10,3,4,5}
													// ind = 2, element = 10
//							where add,  what is index,  what is element
	public static int[] add(int[] array, int index, int element){
		int[] res = new int[array.length + 1];		// create new array + 1 length {0,0,0,0,0,0}
		System.arraycopy(array, 0, res, 0, index); 	// index - this is length {1,2,0,0,0,0}
		res[index] = element;						// {1,2,10,0,0,0}
		System.arraycopy(array, index, res, index + 1, array.length - index);	// {1,2,10, 3,4,5}
		return res;
	}
}