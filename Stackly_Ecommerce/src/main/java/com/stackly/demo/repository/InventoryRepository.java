package com.stackly.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackly.demo.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long>
{


}