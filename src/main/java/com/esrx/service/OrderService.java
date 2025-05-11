package com.esrx.service;

import com.esrx.dao.CustomerRepo;
import com.esrx.dao.OrderRepo;
import com.esrx.entity.Customer;
import com.esrx.entity.Order;
import com.esrx.entity.OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerRepo customerRepo;

    public Order addOrder(Order order){
        return orderRepo.save(order);
    }

    public Order getOrderById(Long id){
        return orderRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
    }


    public List<Order> addOrders(long customerId, List<Order> orders) {
        Customer customer=customerRepo.findById(customerId).orElseThrow();
        for(Order order:orders){
            order.setCustomer(customer);
        }
        return orderRepo.saveAll(orders);
    }
}
