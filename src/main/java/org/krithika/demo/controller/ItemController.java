package org.krithika.demo.controller;

import org.krithika.demo.entity.Item;
import org.krithika.demo.service.ItemService;
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
@RequestMapping("/myFoodDelivery/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    private List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{itemName}")
    private List<Item> getItemsByName(@PathVariable String itemName) {
        return itemService.getItemsByName(itemName);
    }

}
