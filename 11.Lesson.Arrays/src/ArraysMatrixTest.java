import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArraysTest {

	@Test
	void testTrans() {
		int[][] matrix = {{1,2,3},{4,5,6}};
		int[][] expected = {{1,4}, {2,5}, {3,6}};
		assertArrayEquals(expected, ArraysMatrix.transp(matrix));
	}
	
	@Test
	void testAddRow() {
		int[][] matrix = {{1,2}, {3,4}};
		int[] temp = {10,20};
		
		int[][] expectedEnd = {{1,2,10}, {3,4,20}};
		int[][] expectedStart = {{10,1,2}, {20,3,4}};
		int[][] expected1 = {{1,10,2}, {3,20,4}};
		
		assertArrayEquals(expectedStart, ArraysMatrix.addRow(matrix, temp, 0));
		assertArrayEquals(expectedEnd, ArraysMatrix.addRow(matrix, temp, 2));
		assertArrayEquals(expected1, ArraysMatrix.addRow(matrix, temp, 1));
	}
	
	@Test
	void testMatrix(){
		// Option 1
		int[][] matrix = new int[2][2];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[1][0] = 3;
		matrix[1][1] = 4;
		//     0 1
		//	   - -	
		// 0 - 1 3
		// 1 - 2 4
		
		// Option 2
		int[][] matrix1 = {{1,2}, {3,4}};
		
		for(int i = 0; i<matrix.length; i++) {
			for(int j = 0; j<matrix.length;j++) {
				System.out.println(matrix[i][j]);
			}
		}
		System.out.println(Arrays.deepToString(matrix1)); // for matrix
	}
	
	@Test
	void testArray() {
		// option 1
		int[] array = new int[4];
		array[0] = 10;
		array[3] = -10;
		
		// option 2
		int[] array1 = {1,2,3,4};
		int[] array2 = {1,2,3,4};
		int[] array3 = array2;
		
		assertNotEquals(array1, array2);
		assertEquals(array3, array2);
		assertArrayEquals(array1, array2);	// for array!!!
		
		System.out.println(Arrays.toString(array));
		
		// sort
		// 1
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		// 2
		array = new int[] {3,6,1,-59, 5};
		Arrays.sort(array, 1, array.length-1);
		System.out.println(Arrays.toString(array));
		
		// binary search
		System.out.println(Arrays.binarySearch(array1, 3));
		System.out.println(Arrays.binarySearch(array1, 6));		// -5
		
		array = new int[] {3,6,10,23,111,500};
		System.out.println(Arrays.binarySearch(array1, 50));	// -5
	
		// copyOf (always start from 0 index)
		int[] array4 = Arrays.copyOf(array, 3);
		System.out.println(Arrays.toString(array4));	// 3 6 10
		
		// System arraycopy   indS    whereS whereF in array4
		System.arraycopy(array, 2, array4, 0, 3);
		System.out.println(Arrays.toString(array4));	// 10 23 111
	
		// copyOf UP
		array4 = Arrays.copyOf(array, 10);
		System.out.println(Arrays.toString(array4));	// 3 6 10 23 111 500 0 0 0 0
		
		// ERROR
//		System.arraycopy(array, 2, array4, 0, 10);
//		System.out.println(Arrays.toString(array4));
	
		// fill
		int[] array5 = new int[10];
		Arrays.fill(array5, 10);
		System.out.println(Arrays.toString(array5));	// 10 10 10 10 10 10 10 10 10 10
	}

}