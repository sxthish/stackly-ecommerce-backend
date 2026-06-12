package com.stackly.demo.dto;

import lombok.Data;

@Data
public class CartDto 
{
	private Long userId;

    private Long productId;

    private Integer quantity;
}
