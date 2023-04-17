import java.util.Arrays;

public class Complexity {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};

//		O(1)
		@SuppressWarnings("unused")
		int number = array[2];
		
//		O(n)
		@SuppressWarnings("unused")
		int sum = 0;
		for(int num: array)
		{
			sum += num;
		}
		
//		O(log(n))
		@SuppressWarnings("unused")
		int index = Arrays.binarySearch(array, 2);
		
//		O(n^2)
		for(int i=0; i<array.length; i++)
		{
			for(int j=0; j<array.length-1; j++)
			{
				if(array[j] < array[j+1])
					swap();
			}
		}
		
//		O(n*log(n))
		Arrays.sort(array);//quickSort
		
//		1. add-> sort             O(1)+O(n*log(n))=O(n*log(n))
//		2. binareSearch -> add	  O(log(n))+O(n)=O(n)	
	}

	private static void swap() {
		// TODO Auto-generated method stub
		
	}

}