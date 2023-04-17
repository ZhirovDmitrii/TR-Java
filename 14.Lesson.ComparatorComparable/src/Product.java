public class Product implements Comparable<Product>
{
	public String name;
	public double price;
	
	public Product(String name, double price)
	{
		super();
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString()
	{
		return "Product [name=" + name + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product o)
	{
		int res = Double.compare(price, o.price);
		if(res == 0)
			res = name.compareTo(o.name);
		return res;
	}
	
	
}