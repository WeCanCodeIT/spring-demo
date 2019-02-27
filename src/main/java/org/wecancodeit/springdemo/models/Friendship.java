package org.wecancodeit.springdemo.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Friendship {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToMany
	private Collection<Person> people;
	
	public Friendship() {}

	public Friendship(String name, Person ...people) {
		this.name = name;
		this.people = Arrays.asList(people);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Person> getPeople() {
		return people;
	}
	
	public void addPersonToPeople(Person person) {
		people.add(person);
	}

	@Override
	public String toString() {
		return "Friendship [id=" + id + ", name=" + name + ", people=" + people + "]";
	}
}
