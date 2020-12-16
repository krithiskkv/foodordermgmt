package org.krithika.demo.controller;

import org.krithika.demo.entity.Order;
import org.krithika.demo.entity.OrderDetail;
import org.krithika.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by administrator on 5/12/20.
 */
@RestController
@RequestMapping("/myFoodDelivery/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    private List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{userName")
    private List<Order> getOrders(@PathVariable String userName) {
        return orderService.findByUserName(userName);
    }

    @PostMapping("/{userName}")
    private List<String> placeOrder(@PathVariable String userName, @RequestBody List<OrderDetail> orderDetails) {
        return orderService.placeOrder(userName, orderDetails);
    }

}
