package com.stackly.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackly.demo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>
{
	List<Order> findByUserUserId(Long userId);
}
