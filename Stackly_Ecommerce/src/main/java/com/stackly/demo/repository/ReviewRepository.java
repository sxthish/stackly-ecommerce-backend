package com.stackly.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackly.demo.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>
{
	List<Review> findByProductProductId(Long productId);
}
