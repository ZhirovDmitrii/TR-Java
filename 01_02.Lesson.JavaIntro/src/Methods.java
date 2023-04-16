
public class Methods {
	public static void main(String[] args) {
		display();
		
		String name = "Ivan";
		printName(name);
		printName("Julia");
		
		int res = getNumber();
		System.out.println(res);
		
		System.out.println(sum(10, res));
		}
	
	// 1 type
	public static void display()
	{
		System.out.println("Hello world");
	}
	
	// 2 type
	public static void printName(String name)
	{
		System.out.println("Hello " + name);
		System.out.printf("Hello %s\n", name);
		String.format("Hello %s", name);
	}
	
	// 3 type
	public static int getNumber()
	{
		return 100;
	}
	
	// 4 type
	public static int sum(int x, int y)
	{
		return x + y;
	}
}