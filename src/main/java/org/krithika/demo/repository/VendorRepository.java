package org.krithika.demo.repository;

import org.krithika.demo.entity.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by administrator on 5/12/20.
 */
@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {

    List<Vendor> findByNameContainsIgnoreCase(String itemString);

}
