package com.food.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.food.demo.model.Order;
import com.food.demo.service.OrderService;


@RestController
@Validated
public class OrderController {

    @Autowired
    OrderService orderService;

    
    @GetMapping("/orders")
    public List<Order> getAllOrders() 
    {
    	return orderService.getAllOrders();
    }


    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable int id) 
    {
    	return orderService.getOrderById(id);
    }

    
    @PostMapping("/orders")
    public Order addOrder(@Valid @RequestBody Order order) 
    {
    	return orderService.addOrder(order);
    }

    
    @PutMapping("/orders/{id}")
    public String updateOrder(@PathVariable int id, @Validated @RequestBody Order order) 
    {
        return orderService.updateOrder(id, order);
    }

    
    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable int id) 
    {
        return orderService.deleteOrder(id);
    }
}