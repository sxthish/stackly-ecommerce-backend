package com.stackly.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="shipments")
public class Shipment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shipmentId;

	@OneToOne
    @JoinColumn(name="order_id")
	private Order order;

	private String trackingNumber;

	private String currentLocation;

	private LocalDateTime shippedDate;

	private LocalDateTime deliveryDate;


	@Enumerated(EnumType.STRING)
    private ShipmentStatus status;
}
