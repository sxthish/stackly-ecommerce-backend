package com.stackly.demo.service;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.stackly.demo.dto.APIResponse;
import com.stackly.demo.dto.CartDto;
import com.stackly.demo.entity.Cart;
import com.stackly.demo.entity.CartItem;
import com.stackly.demo.entity.Product;
import com.stackly.demo.entity.User;
import com.stackly.demo.repository.CartRepository;
import com.stackly.demo.repository.ProductRepository;
import com.stackly.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CartServiceImpl implements CartService 
{
	private final CartRepository cartRepository;

	private final UserRepository userRepository;
	
	private final ProductRepository productRepository;

	public CartServiceImpl(CartRepository cartRepository,UserRepository userRepository,ProductRepository productRepository)
	{
		this.cartRepository=cartRepository;
	
		this.userRepository=userRepository;
		
		this.productRepository=productRepository;
    }


	@Override
	@Transactional
	public ResponseEntity<?> addToCart(CartDto dto) 
	{
		User user = userRepository.findById(dto.getUserId())
				.orElseThrow(()-> new ResourceNotFoundException("User not found"));

		Product product =productRepository.findById(dto.getProductId())
				.orElseThrow(()-> new ResourceNotFoundException("Product not found"));

		Cart cart = cartRepository.findByUserUserId(dto.getUserId())
				.orElse(new Cart());

		cart.setUser(user);

		CartItem item=new CartItem();

		item.setCart(cart);

		item.setProduct(product);

		item.setQuantity(dto.getQuantity());

		item.setPrice(product.getPrice()*dto.getQuantity());

		cart.getItems().add(item);

	    double total =cart.getItems()
	    		.stream().mapToDouble(CartItem::getPrice).sum();

	    cart.setTotalAmount(total);

	    cartRepository.save(cart);

	    return ResponseEntity.ok(new APIResponse<>(LocalDateTime.now(),
	    		200,"Product Added To Cart",cart));

	
	}
	
	@Override
	public ResponseEntity<?> getCart(Long userId)
	{
		Cart cart = cartRepository.findByUserUserId(userId)
				.orElseThrow(()-> new ResourceNotFoundException("Cart not found"));

		return ResponseEntity.ok(cart);
	}


	@Override
	public ResponseEntity<?> removeItem(Long itemId) {
		// TODO Auto-generated method stub
		return null;
	}
}


