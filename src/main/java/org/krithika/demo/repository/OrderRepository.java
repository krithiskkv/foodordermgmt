package org.krithika.demo.repository;

import org.krithika.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by administrator on 5/12/20.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


}
