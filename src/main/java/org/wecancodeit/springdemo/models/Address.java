package org.wecancodeit.springdemo.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;
	private String streetName;
	private String city;
	private String stateName;
	private String zipCode;
	
	@OneToMany(mappedBy="address")
	private Collection<Person> people;
	
	public Address() {}
	
	public Address(String streetName, String city, String stateName, String zipCode) {
		this.streetName = streetName;
		this.city = city;
		this.stateName = stateName;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getCity() {
		return city;
	}

	public String getStateName() {
		return stateName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Collection<Person> getPeople() {
		return people;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetName=" + streetName + ", city=" + city + ", stateName=" + stateName
				+ ", zipCode=" + zipCode + "]";
	}
}
