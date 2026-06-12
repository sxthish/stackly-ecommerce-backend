package com.stackly.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.stackly.demo.dto.APIResponse;
import com.stackly.demo.entity.Cart;
import com.stackly.demo.entity.Inventory;
import com.stackly.demo.entity.Order;
import com.stackly.demo.entity.OrderItem;
import com.stackly.demo.entity.OrderStatus;
import com.stackly.demo.entity.Product;
import com.stackly.demo.entity.User;
import com.stackly.demo.repository.CartRepository;
import com.stackly.demo.repository.InventoryRepository;
import com.stackly.demo.repository.OrderRepository;
import com.stackly.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService 
{
	private final OrderRepository orderRepository;

	private final UserRepository userRepository;

	private final CartRepository cartRepository;

	private final InventoryRepository inventoryRepository;

	
	public OrderServiceImpl(OrderRepository orderRepository,
			UserRepository userRepository,
			CartRepository cartRepository,
			InventoryRepository inventoryRepository)
	{

		this.orderRepository=orderRepository;

		this.userRepository=userRepository;

		this.cartRepository=cartRepository;

		this.inventoryRepository=inventoryRepository;
}

	@Override
	@Transactional
	public ResponseEntity<?> placeOrder(Long userId)
	{
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found"));

		Cart cart = cartRepository.findByUserUserId(userId)
				.orElseThrow(()-> new ResourceNotFoundException("Cart Empty"));

		Order order=new Order();
		
		order.setUser(user);
		
	    order.setStatus(OrderStatus.PLACED);

	    order.setOrderDate(LocalDateTime.now());

        order.setTotalAmount(cart.getTotalAmount());

        List<OrderItem> orderItems =cart.getItems()
        		.stream().map(cartItem -> {

        Product product = cartItem.getProduct();

	    Inventory inventory = product.getInventory();

	    inventory.setAvailableStock(

	    inventory.getAvailableStock()-cartItem.getQuantity());


	    OrderItem item = new OrderItem();

	    item.setOrder(order);

	    item.setProduct(product);

	    item.setQuantity(cartItem.getQuantity());

	    item.setPrice(cartItem.getPrice());

	    return item;
	 })
	.toList();

    order.setOrderItems(orderItems);

    orderRepository.save(order);

	cart.getItems().clear();

	cart.setTotalAmount(0.0);

	cartRepository.save(cart);

	return ResponseEntity.ok(new APIResponse<>(LocalDateTime.now(),
			200,"Order Placed Successfully",order));
	}

	@Override
	public ResponseEntity<?> getUserOrders(Long userId)
	{
		return ResponseEntity.ok(orderRepository.findByUserUserId(userId));
	}

	@Override
	public ResponseEntity<?> cancelOrder(Long orderId)
	{
		Order order = orderRepository.findById(orderId)
				.orElseThrow(()-> new ResourceNotFoundException("Order not found"));

		order.setStatus(OrderStatus.CANCELLED);

		orderRepository.save(order);

		return ResponseEntity.ok("Order Cancelled");
	}
}
