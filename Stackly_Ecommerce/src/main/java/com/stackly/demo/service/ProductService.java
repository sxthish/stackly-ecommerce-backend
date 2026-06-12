package com.stackly.demo.service;

import org.springframework.http.ResponseEntity;

import com.stackly.demo.dto.ProductDto;

public interface ProductService 
{
    ResponseEntity<?> createProduct(ProductDto dto);

    ResponseEntity<?> getAllProducts();

    ResponseEntity<?> getProductById(Long id);

    ResponseEntity<?> deleteProduct(Long id);
    
    ResponseEntity<?> searchProducts(String name);

    ResponseEntity<?> getProductsWithPagination(int page,int size,String sortBy);

}
