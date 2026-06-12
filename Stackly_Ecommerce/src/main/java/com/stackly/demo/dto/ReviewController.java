package com.stackly.demo.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.demo.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController 
{
	private final ReviewService reviewService;
    
	public ReviewController(ReviewService reviewService)
    {
		this.reviewService=reviewService;
    }


	@PostMapping
	public ResponseEntity<?> add(@RequestBody ReviewDto dto)
	{
		return reviewService.addReview(dto);
    }


	@GetMapping("/product/{id}")
	public ResponseEntity<?> get(@PathVariable Long id)
	{
		return reviewService.getProductReviews(id);
    }
}
