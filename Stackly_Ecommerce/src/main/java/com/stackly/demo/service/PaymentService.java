package com.stackly.demo.service;

import org.springframework.http.ResponseEntity;

import com.stackly.demo.dto.PaymentDto;

public interface PaymentService 
{
	ResponseEntity<?> makePayment(PaymentDto dto);

	ResponseEntity<?> getPayment(Long id);
}
