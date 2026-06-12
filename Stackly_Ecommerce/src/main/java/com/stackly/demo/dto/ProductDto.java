package com.stackly.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDto 
{
    private Long productId;

    @NotBlank(message="Product name required")
    private String productName;

    private String description;

    private Double price;

    private String imageUrl;

    private Integer availableStock;

    private Long categoryId;


}
