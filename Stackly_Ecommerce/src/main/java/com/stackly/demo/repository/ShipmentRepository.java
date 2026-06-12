package com.stackly.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackly.demo.entity.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment,Long>{


}