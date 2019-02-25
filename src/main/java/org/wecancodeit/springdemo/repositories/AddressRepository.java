package org.wecancodeit.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.springdemo.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

	Address findByStreetName(String streetName);

	Address findByStreetNameAndCityAndStateNameAndZipCode(String streetName, String city, String stateName,
			String zipCode);

}
