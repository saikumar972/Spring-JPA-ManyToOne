package com.esrx.controller;

import com.esrx.entity.Order;
import com.esrx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    @GetMapping("/id/{id}")
    public  Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
}
