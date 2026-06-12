package com.stackly.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDto {


    private Long categoryId;


    @NotBlank(message="Category name required")
    private String categoryName;


    private String description;


}
