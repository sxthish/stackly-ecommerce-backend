package com.stackly.demo.dto;

import com.stackly.demo.entity.PaymentMethod;

import lombok.Data;

@Data
public class PaymentDto 
{
	private Long orderId;

	private PaymentMethod method;
}