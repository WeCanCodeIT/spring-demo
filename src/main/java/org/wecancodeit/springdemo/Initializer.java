package org.wecancodeit.springdemo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.springdemo.models.Address;
import org.wecancodeit.springdemo.models.Person;
import org.wecancodeit.springdemo.repositories.AddressRepository;
import org.wecancodeit.springdemo.repositories.PeopleRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	PeopleRepository peopleRepo;

	@Resource
	AddressRepository addressRepo;

	@Override
	public void run(String... args) throws Exception {
		Address address = addressRepo.save(new Address("123 Fake Street", "Columbus", "OH", "43202"));
		
		peopleRepo.save(new Person("Ajax", 31, "#39add1", address));
		peopleRepo.save(new Person("JavaScript", 41, "#c0ffee", address));
		peopleRepo.save(new Person("Java", 51, "#bada55", address));
	}

}
