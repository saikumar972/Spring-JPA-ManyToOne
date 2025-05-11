package com.esrx.controller;

import com.esrx.entity.Order;
import com.esrx.entity.OrderList;
import com.esrx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    @PostMapping("/bulk")
    public List<Order> addOrderList(@RequestBody OrderList orderList){
        return orderService.addOrders(orderList.getCustomerId(),orderList.getOrders());
    }

    @GetMapping("/id/{id}")
    public  Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
}
