package org.wecancodeit.springdemo.repositories;

import java.util.List;

import org.wecancodeit.springdemo.models.Person;

/**
 * This will be a good resource to see what repositories do in the
 * Spring Framework.
 * 
 * This is only meant to keep a list of Person(s) and any logic to manipulate
 * their data through the Collection
 * 
 * @author donhamiltoniii
 *
 */
public class OriginalPeopleRepository {
	
	private List<Person> people;

	public OriginalPeopleRepository(List<Person> people) {
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

	public Person findPerson(String name) {
		Person foundPerson = null;
		for (Person person : people) {
			if (person.getName().equals(name)) {
				foundPerson = person;
			}
		}
		return foundPerson;
	}
	
}
