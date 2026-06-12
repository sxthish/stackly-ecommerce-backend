package com.stackly.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackly.demo.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long>
{
	Optional<Cart> findByUserUserId(Long userId);
}
