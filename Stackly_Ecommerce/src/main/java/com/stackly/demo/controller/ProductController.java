package com.stackly.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackly.demo.dto.ProductDto;
import com.stackly.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{
	private final ProductService productService;

	public ProductController(ProductService productService)
	{
		this.productService=productService;
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody ProductDto dto)
	{
		return productService.createProduct(dto);
	}

	@GetMapping
	public ResponseEntity<?> all()
	{
		return productService.getAllProducts();
    }

	@GetMapping("/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id)
	{
		return productService.getProductById(id);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		return productService.deleteProduct(id);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam String name)
	{
		return productService.searchProducts(name);
	}
	
	@GetMapping("/page")
	public ResponseEntity<?> pagination(@RequestParam int page,@RequestParam int size,@RequestParam String sortBy)
	{
		return productService.getProductsWithPagination(page,size,sortBy);
	}
}
