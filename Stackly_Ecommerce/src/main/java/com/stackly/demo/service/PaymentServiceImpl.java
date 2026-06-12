package com.stackly.demo.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.stackly.demo.dto.APIResponse;
import com.stackly.demo.dto.PaymentDto;
import com.stackly.demo.entity.Order;
import com.stackly.demo.entity.Payment;
import com.stackly.demo.entity.PaymentStatus;
import com.stackly.demo.repository.OrderRepository;
import com.stackly.demo.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService 
{
	private final PaymentRepository paymentRepository;

	private final OrderRepository orderRepository;

	
	public PaymentServiceImpl(PaymentRepository paymentRepository,OrderRepository orderRepository)
	{
		this.paymentRepository=paymentRepository;

		this.orderRepository=orderRepository;
    }



	@Override
	public ResponseEntity<?> makePayment(PaymentDto dto)
	{
		Order order = orderRepository.findById(dto.getOrderId())
				.orElseThrow(()-> new ResourceNotFoundException("Order not found"));
	
		Payment payment=new Payment();

		payment.setOrder(order);
		payment.setAmount(order.getTotalAmount());
		payment.setMethod(dto.getMethod());

		payment.setStatus(PaymentStatus.SUCCESS);

		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentDate(LocalDateTime.now());

		paymentRepository.save(payment);

		return ResponseEntity.ok(new APIResponse<>(LocalDateTime.now(),
				200,"Payment Successful",payment));
	}



	@Override
	public ResponseEntity<?> getPayment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

