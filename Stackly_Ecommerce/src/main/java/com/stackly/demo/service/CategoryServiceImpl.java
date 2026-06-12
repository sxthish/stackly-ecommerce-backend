package com.stackly.demo.service;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stackly.demo.dto.APIResponse;
import com.stackly.demo.dto.CategoryDto;
import com.stackly.demo.entity.Category;
import com.stackly.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService
{
	private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
    	this.categoryRepository=categoryRepository;
    }

    @Override
    public ResponseEntity<?> createCategory(CategoryDto dto)
    {
    	Category category=new Category();
    	category.setCategoryName(dto.getCategoryName());
    	category.setDescription(dto.getDescription());

        categoryRepository.save(category);

        return ResponseEntity.ok(new APIResponse<>(LocalDateTime.now(),
        		200,"Category Created Successfully",category));
     }


     @Override
     public ResponseEntity<?> getAllCategory()
     {
    	 return ResponseEntity.ok(categoryRepository.findAll());
     }

     


}
