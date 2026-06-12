package com.stackly.demo.service;

import org.springframework.http.ResponseEntity;

import com.stackly.demo.dto.ShipmentDto;
import com.stackly.demo.entity.ShipmentStatus;

public interface ShipmentService 
{
	ResponseEntity<?> createShipment(ShipmentDto dto);

	ResponseEntity<?> updateStatus(Long shipmentId,ShipmentStatus status);
}