package org.wecancodeit.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.springdemo.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
