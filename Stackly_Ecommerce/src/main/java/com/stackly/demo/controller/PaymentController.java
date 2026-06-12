package com.stackly.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.demo.dto.PaymentDto;
import com.stackly.demo.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController 
{
	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService)
	{
		this.paymentService=paymentService;
    }

	
	@PostMapping("/pay")
    public ResponseEntity<?> pay(@RequestBody PaymentDto dto)
	{
		return paymentService.makePayment(dto);
    }
}