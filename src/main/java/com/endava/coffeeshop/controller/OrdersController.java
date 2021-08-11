package com.endava.coffeeshop.controller;

import com.endava.coffeeshop.model.Customer;
import com.endava.coffeeshop.model.Orders;
import com.endava.coffeeshop.repository.OrdersRepository;
import com.endava.coffeeshop.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {
    private final OrdersService ordersService;
    private final OrdersRepository ordersRepository;

    public OrdersController(OrdersService ordersService, OrdersRepository ordersRepository) {
        this.ordersService = ordersService;
        this.ordersRepository = ordersRepository;
    }

    @GetMapping("allOrders")
    public ResponseEntity<List<Orders>> getOrders() {
        List<Orders> orders = null;
        orders = ordersService.getAllOrders();
        return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Orders> addCustomer(@RequestBody Orders order) {
        Orders _order = null;
        try {
            _order = ordersService.addNewOrder(order);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<Orders>(_order, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Orders> update(@PathVariable Integer id, @RequestBody Orders orders) {
        Optional<Orders> _order = ordersRepository.findById(id);
        if (_order.isPresent()) {
            Orders order = _order.get();
            order.setCash(orders.getCash());
            order.setDelivery(orders.getDelivery());
            order.setCustomer(orders.getCustomer());
            order.setCoffee(orders.getCoffee());
            order.setTotal(orders.getTotal());
            order.setAmount(orders.getAmount());
            return new ResponseEntity<>(ordersService.addNewOrder(order), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        ordersService.deleteOrder(id);
    }

}
