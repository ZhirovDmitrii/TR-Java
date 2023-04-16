package oop;

public class Person {
	String name;
	String surName;

	// OVERLOAD
	
	public Person(String name, String surName) {
		super();
		this.name = name;
		this.surName = surName;
	}

//	public Person(String surName, String name) {
//		super();
//		this.name = name;
//		this.surName = surName;
//	}

	public void display() {
		System.out.println(name);
	}

	public void display(String str) {
		System.out.println(surName + str);
	}
	
	

}