package arrays;

public class Arrays {

	public static void main(String[] args) {
		
		// option 1
		int[] array = new int[10];
		array[0] = 10;
		array[5] = 100;
		
		// option 2
		//byte[] array1 = new byte[] {1, 2, 3, 4, 5};
		
		// option 3
		String[] array2 = {"Hello", "world", "Bye"};
		
		System.out.println(array2[1]);
		
		for(int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
		
		System.out.println(getNumber(array));
		
		// continue
		int count = 0;
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == 0 || array[i] % 2 != 0)
				continue;
			count++;
		}
		System.out.println(count);
	}
	
	public static String getNumber(int[] array)
	{
		return array[0] > array[1] ? "Is more" : "Is less";
	}

}