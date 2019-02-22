package org.wecancodeit.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.springdemo.models.Person;

@Repository
public interface PeopleRepository extends CrudRepository<Person, Long> {

//	Person findByName(String name);
//	Person findByAge(int age);

}
