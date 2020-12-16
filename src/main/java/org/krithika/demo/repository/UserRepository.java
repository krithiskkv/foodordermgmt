package org.krithika.demo.repository;

import org.krithika.demo.entity.Item;
import org.krithika.demo.entity.User;
import org.krithika.demo.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by administrator on 5/12/20.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByName(String name);

}
