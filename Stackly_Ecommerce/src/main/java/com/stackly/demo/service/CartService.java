package com.stackly.demo.service;

import org.springframework.http.ResponseEntity;

import com.stackly.demo.dto.CartDto;

public interface CartService 
{
	ResponseEntity<?> addToCart(CartDto dto);

	ResponseEntity<?> getCart(Long userId);

	ResponseEntity<?> removeItem(Long itemId);


}
