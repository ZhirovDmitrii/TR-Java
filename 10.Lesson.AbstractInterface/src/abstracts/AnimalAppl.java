package abstracts;

public class AnimalAppl {

	public static void main(String[] args) {
//		Animal a = new Animal("animal", 10);
//		Pet p = new Pet("pet", 1, 'm');
		Dog d = new Dog("dog", 2, 'f', "breed");
		Fish f = new Fish("fish", 1, 'm', "red");
		Parrot par = new Parrot("parrot", 100, 'f', true);
		
		Animal[] array = {d, f, par};
		for(int i=0; i<array.length; i++)
		{
			array[i].voice();
		}

		IBoxable.box();
	}

}
