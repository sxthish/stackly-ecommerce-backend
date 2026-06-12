package com.stackly.demo.service;

import org.springframework.http.ResponseEntity;

public interface OrderService 
{
	ResponseEntity<?> placeOrder(Long userId);

    ResponseEntity<?> getUserOrders(Long userId);

    ResponseEntity<?> cancelOrder(Long orderId);


}
