package com.stackly.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.demo.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController 
{
	private final OrderService orderService;

	public OrderController(OrderService orderService)
	{
		this.orderService=orderService;
	}

	@PostMapping("/place/{userId}")
    public ResponseEntity<?> place(@PathVariable Long userId)
	{
		return orderService.placeOrder(userId);
    }

	
	@GetMapping("/user/{userId}")
    public ResponseEntity<?> history(@PathVariable Long userId)
	{
		return orderService.getUserOrders(userId);
	}


	@PutMapping("/cancel/{id}")
    public ResponseEntity<?> cancel(@PathVariable Long id)
	{
		return orderService.cancelOrder(id);
	}
}
