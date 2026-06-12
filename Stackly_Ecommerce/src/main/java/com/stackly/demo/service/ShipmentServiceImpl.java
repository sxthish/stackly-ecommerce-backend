package com.stackly.demo.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.stackly.demo.dto.APIResponse;
import com.stackly.demo.dto.ShipmentDto;
import com.stackly.demo.entity.Order;
import com.stackly.demo.entity.Shipment;
import com.stackly.demo.entity.ShipmentStatus;
import com.stackly.demo.repository.OrderRepository;
import com.stackly.demo.repository.ShipmentRepository;

@Service
public class ShipmentServiceImpl implements ShipmentService
{
	private final ShipmentRepository shipmentRepository;

	private final OrderRepository orderRepository;


	public ShipmentServiceImpl(ShipmentRepository shipmentRepository,OrderRepository orderRepository)
	{
		this.shipmentRepository=shipmentRepository;

		this.orderRepository=orderRepository;
    }

	@Override
	public ResponseEntity<?> createShipment(ShipmentDto dto)
	{
		Order order = orderRepository.findById(dto.getOrderId())
				.orElseThrow(()-> new ResourceNotFoundException("Order not found"));

		Shipment shipment=new Shipment();

		shipment.setOrder(order);

		shipment.setTrackingNumber(UUID.randomUUID().toString());

		shipment.setCurrentLocation(dto.getCurrentLocation());

		shipment.setShippedDate(LocalDateTime.now());

		shipment.setStatus(ShipmentStatus.PACKED);

		shipmentRepository.save(shipment);

		return ResponseEntity.ok(new APIResponse<>(LocalDateTime.now(),
				200,"Shipment Created",shipment));
	}

	@Override
	public ResponseEntity<?> updateStatus(Long shipmentId,ShipmentStatus status)
	{
		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(()->new ResourceNotFoundException("Shipment not found"));

		shipment.setStatus(status);

		if(status==ShipmentStatus.DELIVERED)
	    {
			shipment.setDeliveryDate(LocalDateTime.now());
	    }

		shipmentRepository.save(shipment);

		return ResponseEntity.ok("Shipment Updated");
	}
}


