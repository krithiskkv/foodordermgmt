package org.krithika.demo.service;

import org.krithika.demo.entity.Item;
import org.krithika.demo.entity.Vendor;
import org.krithika.demo.repository.ItemRepository;
import org.krithika.demo.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by administrator on 5/12/20.
 */
@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public List<Vendor> getVendorsByName(String vendorString) {
        return vendorRepository.findByNameContainsIgnoreCase(vendorString);
    }
}
