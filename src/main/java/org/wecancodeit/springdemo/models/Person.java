package org.wecancodeit.springdemo.models;

/**
 * Person is just a POJO similar to a VirtualPet (or any version of a
 * VirtualPet)
 * 
 * This is just meant to map our data. This shouldn't contain much logic.
 * 
 * @author donhamiltoniii
 *
 */
public class Person {

	private String name;
	private int age;
	private String favColor;

	public Person(String name, int age, String favColor) {
		this.name = name;
		this.age = age;
		this.favColor = favColor;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getFavColor() {
		return favColor;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", favColor=" + favColor + "]";
	}

}
