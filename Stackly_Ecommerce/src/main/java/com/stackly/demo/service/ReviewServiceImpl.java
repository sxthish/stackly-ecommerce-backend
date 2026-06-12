package com.stackly.demo.service;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.stackly.demo.dto.APIResponse;
import com.stackly.demo.dto.ReviewDto;
import com.stackly.demo.entity.Product;
import com.stackly.demo.entity.Review;
import com.stackly.demo.entity.User;
import com.stackly.demo.repository.ProductRepository;
import com.stackly.demo.repository.ReviewRepository;
import com.stackly.demo.repository.UserRepository;

@Service
public class ReviewServiceImpl implements ReviewService
{
	private final ReviewRepository reviewRepository;

	private final UserRepository userRepository;

	private final ProductRepository productRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository,UserRepository userRepository,ProductRepository productRepository)
    {
    this.reviewRepository=reviewRepository;

    this.userRepository=userRepository;

    this.productRepository=productRepository;
    }


	@Override
	public ResponseEntity<?> addReview(ReviewDto dto)
	{
		User user =userRepository.findById(dto.getUserId())
				.orElseThrow(()-> new ResourceNotFoundException("User not found"));

		Product product = productRepository.findById(dto.getProductId())
				.orElseThrow(()-> new ResourceNotFoundException("Product not found"));

		Review review=new Review();

		review.setUser(user);

		review.setProduct(product);

		review.setRating(dto.getRating());

		review.setComment(dto.getComment());

		review.setCreatedDate(LocalDateTime.now());

		reviewRepository.save(review);


		return ResponseEntity.ok(new APIResponse<>(LocalDateTime.now(),
				200,"Review Added",review));
	}


	@Override
	public ResponseEntity<?> getProductReviews(Long productId)
	{
		return ResponseEntity.ok(reviewRepository.findByProductProductId(productId));
	}
}
