package oop;

public class AnimalApp {

	public static void main(String[] args) {
		Animal animal = new Animal();

		Animal animal1 = new Animal("Bogdana", 16);

		System.out.println(animal);
		System.out.println(animal1);

		System.out.println(animal1.getAge());
		System.out.println(animal1.getName());

		animal1.setAge(120);
		System.out.println(animal1.getAge());

		// Animal animal = new Animal("Name", 1000);

		Animal an1 = new Animal("", -10);
		System.out.println(an1);

		an1.setAge(10);
		System.out.println(an1); // = 10

		an1.setAge(5);
		System.out.println(an1); // = 10

//		Dog dog = new Dog("Dog", 1, "boxer");
//		Cat cat = new Cat("Cat", 10, "black");
		Fish fish = new Fish("Fish", 2, false);

//		System.out.println(fish);

//		dog.voice();
//		fish.voice();
//		cat.voice();

		// CASTING

		Animal dog = new Dog("Dog", 1, "boxer");
		Animal cat = new Cat("Cat", 10, "black");
//		Object fish = new Fish("Fish", 2, false);
		Fish fish1 = new Fish("Fish", 2, false);
		Fish fish2 = fish;

		System.out.println(cat);

		Animal[] array = { an1, dog, cat, (Animal) fish };

//		Dog dog1 = (Dog) cat; - WRONG CAST, need instanceOf

		for (int i = 0; i < array.length; i++) {
			if (array[i] instanceof Fish)
				((Fish) array[i]).voiceFish();
			else if (array[i] instanceof Dog)
				((Dog) array[i]).voiceDog();
			else if (array[i] instanceof Cat)
				((Cat) array[i]).voiceCat();
			else if (array[i] instanceof Animal)
				array[i].voiceAnimal();
			else
				System.out.println("Kto ti tvar?");

		}
		
		System.out.println(fish == fish1);
		System.out.println(fish == fish2);
		System.out.println(fish.equals(fish2));

	}

}