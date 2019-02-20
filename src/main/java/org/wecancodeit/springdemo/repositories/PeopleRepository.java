package org.wecancodeit.springdemo.repositories;

import java.util.List;

import org.wecancodeit.springdemo.models.Person;

public class PeopleRepository {
	
	private List<Person> people;

	public PeopleRepository(List<Person> people) {
		this.people = people;
	}

	public List<Person> getPeople() {
		return people;
	}
	
	public void addPerson(Person person) {
		people.add(person);
	}

	@Override
	public String toString() {
		return "PeopleRepository [people=" + people + "]";
	}
	
}
