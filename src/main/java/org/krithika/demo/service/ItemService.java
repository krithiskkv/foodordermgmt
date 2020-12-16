package org.krithika.demo.service;

import org.krithika.demo.entity.Item;
import org.krithika.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by administrator on 5/12/20.
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> getItemsByName(String itemString) {
        return itemRepository.findByNameContainsIgnoreCase(itemString);
    }

}
