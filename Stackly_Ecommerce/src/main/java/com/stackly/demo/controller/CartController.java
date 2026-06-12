package com.stackly.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.demo.dto.CartDto;
import com.stackly.demo.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController 
{
	private final CartService cartService;

	public CartController(CartService cartService)
	{
		this.cartService=cartService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CartDto dto)
	{
		return cartService.addToCart(dto);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> get(@PathVariable Long userId)
	{
		return cartService.getCart(userId);
	}
}
