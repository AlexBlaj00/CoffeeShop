package com.endava.coffeeshop.service;

import com.endava.coffeeshop.model.Orders;
import com.endava.coffeeshop.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }


    public List<Orders> getAllOrders() {
        return (List<Orders>) ordersRepository.findAll();
    }

    public Orders addNewOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public Orders find(Integer id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Integer id) {
        ordersRepository.deleteById(id);
    }
}
