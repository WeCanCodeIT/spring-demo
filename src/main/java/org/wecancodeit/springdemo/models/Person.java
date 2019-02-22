package org.wecancodeit.springdemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Person is just a POJO similar to a VirtualPet (or any version of a
 * VirtualPet)
 * 
 * This is just meant to map our data. This shouldn't contain much logic.
 * 
 * @author donhamiltoniii
 *
 */
@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int age;
	private String favColor;
	
	// Don't use this constructor - Just for JPA
	public Person() {}

	public Person(String name, int age, String favColor) {
		this.name = name;
		this.age = age;
		this.favColor = favColor;
	}
	
	public Long getId() {
		return id;
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
