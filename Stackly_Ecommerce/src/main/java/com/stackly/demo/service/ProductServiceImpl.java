package com.stackly.demo.service;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.stackly.demo.dto.APIResponse;
import com.stackly.demo.dto.ProductDto;
import com.stackly.demo.entity.Category;
import com.stackly.demo.entity.Inventory;
import com.stackly.demo.entity.Product;
import com.stackly.demo.repository.CategoryRepository;
import com.stackly.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService 
{
	private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository) 
    {
    	this.productRepository = productRepository;

        this.categoryRepository = categoryRepository;
    }


    @Override
    public ResponseEntity<?> createProduct(ProductDto dto) 
    {
    	Category category = categoryRepository.findById(dto.getCategoryId())
    			.orElseThrow(()-> new ResourceNotFoundException("Category not found"));

        Product product = new Product();

        product.setProductName(dto.getProductName());

        product.setDescription(dto.getDescription());

        product.setPrice(dto.getPrice());

        product.setImageUrl(dto.getImageUrl());

        //relationship
        product.setCategory(category);


        Inventory inventory=new Inventory();

        inventory.setAvailableStock(dto.getAvailableStock());

        inventory.setReservedStock(0);

        inventory.setProduct(product);

        product.setInventory(inventory);


        productRepository.save(product);

        return ResponseEntity.ok(new APIResponse<>(LocalDateTime.now(),
        		200,"Product Added Successfully",product));
    }

    @Override
    public ResponseEntity<?> getAllProducts()
    {
    	return ResponseEntity.ok(productRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getProductById(Long id)
    {
    	Product product = productRepository.findById(id)
    			.orElseThrow(()->new ResourceNotFoundException("Product not found"));
    	
    	return ResponseEntity.ok(product);
    }


    @Override
    public ResponseEntity<?> deleteProduct(Long id)
    {
    	productRepository.deleteById(id);

    	return ResponseEntity.ok(new APIResponse<>(LocalDateTime.now(),
    			200,"Product Deleted",null));
    }
    
    @Override
    public ResponseEntity<?> searchProducts(String name)
    {
    	List<Product> products =productRepository.findByProductNameContainingIgnoreCase(name);
    	return ResponseEntity.ok(new APIResponse<>(LocalDateTime.now(),
    			200,"Products fetched successfully",products));
    }
    
    @Override
    public ResponseEntity<?> getProductsWithPagination(int page,int size,String sortBy)
    {
    	Pageable pageable = PageRequest.of(page,size,Sort.by(sortBy));
    	
    	Page<Product> products = productRepository.findAll(pageable);

    	return ResponseEntity.ok(new APIResponse<>(LocalDateTime.now(),
    			200,"Products fetched",products.getContent()));
    }

}
