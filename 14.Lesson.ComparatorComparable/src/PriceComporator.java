import java.util.Comparator;

public class PriceComporator implements Comparator<Product>
{

	@Override
	public int compare(Product o1, Product o2)
	{
		return Double.compare(o1.price, o2.price);
	}

}