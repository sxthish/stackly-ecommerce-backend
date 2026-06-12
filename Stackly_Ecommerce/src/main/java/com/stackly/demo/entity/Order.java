package com.stackly.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="orders")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;


	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;


	@OneToMany(
	        mappedBy = "order",
	        cascade = CascadeType.ALL
	)
	private List<OrderItem> orderItems =new ArrayList<>();

	private Double totalAmount;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@OneToOne(mappedBy="order",cascade=CascadeType.ALL)
	private Payment payment;
	
	@OneToOne(mappedBy="order",cascade=CascadeType.ALL)
	private Shipment shipment;
	
	private LocalDateTime orderDate;


}
