package com.stackly.demo.service;

import org.springframework.http.ResponseEntity;

import com.stackly.demo.dto.CategoryDto;

public interface CategoryService 
{
	ResponseEntity<?> createCategory(CategoryDto dto);

    ResponseEntity<?> getAllCategory();


}
