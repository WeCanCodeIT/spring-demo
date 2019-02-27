package org.wecancodeit.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.springdemo.models.Friendship;

@Repository
public interface FriendshipRepository extends CrudRepository<Friendship, Long> {

}
