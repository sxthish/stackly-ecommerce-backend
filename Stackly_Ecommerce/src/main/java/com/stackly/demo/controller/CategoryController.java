package com.stackly.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.demo.dto.CategoryDto;
import com.stackly.demo.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController 
{
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService)
	{
		this.categoryService=categoryService;
	}


    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CategoryDto dto)
    {
    	return categoryService.createCategory(dto);
    }


    @GetMapping
    public ResponseEntity<?> getAll()
    {
    	return categoryService.getAllCategory();
    }
}
