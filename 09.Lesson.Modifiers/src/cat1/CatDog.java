package cat1;

import cat.Cat;

public class CatDog extends Cat{
	public void print()
	{
		System.out.println(name);
//		System.out.println(age); - private
		System.out.println(weight);
//		System.out.println(trained); - has no modifier
	}
}
