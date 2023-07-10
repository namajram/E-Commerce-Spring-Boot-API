package com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.entities.Cart;
import com.api.entities.Order;
import com.api.entities.User;
import com.api.repository.CartRepository;
import com.api.repository.UserRepository;
import com.api.service.OrderService;

public class OrderServiceImpl implements OrderService {

//	@Autowired
//	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private OrderItemRepository orderItemRepository;
//	
//	@Autowired
//	private OrderRepository orderRepository;
	
	@Override
	public List<Cart> checkoutCart(Long userId) {
		User user = userRepository.findById(userId).get();
		Order order =new Order();
		order.setUser(user);
		 List<Cart> findByUser_UserId = cartRepository.findByUser_UserId(userId);
		return findByUser_UserId;
//		findByUser.iterator().next().
//		for (int i = 0; i < findByUser.size(); i++) {
//		
//		}
		
		
	
		
	}
}
