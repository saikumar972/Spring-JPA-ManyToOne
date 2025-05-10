package com.esrx.service;

import com.esrx.dao.OrderRepo;
import com.esrx.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    public Order addOrder(Order order){
        return orderRepo.save(order);
    }

    public Order getOrderById(Long id){
        return orderRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
    }
}
