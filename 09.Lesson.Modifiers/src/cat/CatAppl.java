package cat;

public class CatAppl extends Cat{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		System.out.println(cat.name);
//		System.out.println(cat.age); - private
		System.out.println(cat.weight);
		System.out.println(cat.trained);
	}

}