package com.stackly.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.demo.dto.ShipmentDto;
import com.stackly.demo.entity.ShipmentStatus;
import com.stackly.demo.service.ShipmentService;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController 
{
	private final ShipmentService shipmentService;

	
	public ShipmentController(ShipmentService shipmentService)
	{
		this.shipmentService=shipmentService;
    }
	
	
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ShipmentDto dto)
    {
    	return shipmentService.createShipment(dto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestParam ShipmentStatus status)
    {
    	return shipmentService.updateStatus(id,status);
    }
}
