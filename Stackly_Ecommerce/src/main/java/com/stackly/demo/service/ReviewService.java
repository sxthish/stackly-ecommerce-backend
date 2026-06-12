package com.stackly.demo.service;

import org.springframework.http.ResponseEntity;

import com.stackly.demo.dto.ReviewDto;

public interface ReviewService 
{
	ResponseEntity<?> addReview(ReviewDto dto);

	ResponseEntity<?> getProductReviews(Long productId);
}
