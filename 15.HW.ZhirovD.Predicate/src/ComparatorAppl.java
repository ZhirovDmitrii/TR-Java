import java.util.Arrays;

public class ComparatorAppl
{

	public static void main(String[] args)
	{
		Product p = new Product("a", 1.1);
		Product p1 = new Product("a", 10.1);
		Product p2 = new Product("b", 1.1);
		
		Product[] array = {p, p1, p2};
		System.out.println(Arrays.toString(array));
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		Arrays.sort(array, new PriceComporator());
	}

}