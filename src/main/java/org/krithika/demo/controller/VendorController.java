package org.krithika.demo.controller;

import org.krithika.demo.entity.Item;
import org.krithika.demo.entity.Vendor;
import org.krithika.demo.service.ItemService;
import org.krithika.demo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by administrator on 5/12/20.
 */
@RestController
@RequestMapping("/myFoodDelivery/vendors")
public class VendorController {
    @Autowired
    VendorService vendorService;

    @GetMapping
    private List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{vendorName}")
    private List<Vendor> getVendorsByName(@PathVariable String vendorName) {
        return vendorService.getVendorsByName(vendorName);
    }
}
