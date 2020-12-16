package org.krithika.demo.service;

import org.krithika.demo.entity.*;
import org.krithika.demo.repository.ItemRepository;
import org.krithika.demo.repository.OrderRepository;
import org.krithika.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by administrator on 5/12/20.
 */
@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    private User user = null;
    private Set<ItemOrderQty> itemOrderQtySet = new HashSet<>();

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> findByUserName(String userName) {
        return null;
    }

    public List<String> placeOrder(String userName, List<OrderDetail> orderDetails) {
        List<String> responseList = new ArrayList<>();

        if (isValidUserName(userName)) {
            orderDetails.forEach(orderDetail -> {if (!isItemAvailable(orderDetail)) {
                responseList.add("Item with id: " + orderDetail.getItemId() + " is not available");
            }});

            if (responseList.isEmpty()) {
                orderDetails.forEach(this::updateItemQuantity);
                Order order = new Order();
                order.setOrderedItems(itemOrderQtySet);
                order.setOrderDate((new Date()));
                order.setOrderingUser(user);
                orderRepository.save(order);
                responseList.add("Order placed successfully!");
            }

        } else {
            responseList.add("Invalid username: " + userName);
        }
        return responseList;
    }

    private boolean isValidUserName(String userName) {
        Optional<User> result =  userRepository.findByName(userName);
        if(result.isPresent()) {
            user = result.get();
            return true;
        } else {
            user = null;
            return false;
        }
    }

    private boolean isItemAvailable(OrderDetail orderDetail) {
        Optional<Item> itemById = itemRepository.findById(orderDetail.getItemId());
        if (itemById.isPresent()) {
            Item item = itemById.get();
            return item.getAvailableQty() - orderDetail.getQty() >= 0 ;
        }
        return false;
    }

    private void updateItemQuantity(OrderDetail orderDetail) {
            Item item = itemRepository.findById(orderDetail.getItemId()).get();
            Integer updatedQty = item.getAvailableQty() - orderDetail.getQty();
            item.setAvailableQty(updatedQty);
            itemRepository.save(item);
            itemOrderQtySet.add(new ItemOrderQty(item.getId(), orderDetail.getQty()));
    }

}
