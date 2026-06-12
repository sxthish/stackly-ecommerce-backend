package com.stackly.demo.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="products")
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	private String productName;
	
	private String description;
	
	private Double price;
	
	private String imageUrl;
	
	
	@ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
	
	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    private Inventory inventory;

	@ToString.Exclude
	@OneToMany(
	        mappedBy = "product",
	        cascade = CascadeType.ALL
	)
	private List<Review> reviews =
	        new ArrayList<>();
}
