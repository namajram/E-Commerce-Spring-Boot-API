package com.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entities.Cart;
import com.api.entities.Product;
import com.api.entities.User;
import com.api.repository.CartRepository;
import com.api.repository.ProductRepository;
import com.api.repository.UserRepository;
import com.api.service.CartService;
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Cart addCart(Long productId, Long userId) {
		Product findById = productRepository.findById(productId).get();
		User user = userRepository.findById(userId).get();
		Cart cart =new Cart();
		cart.setProduct(findById);
		cart.setUser(user);
		return cartRepository.save(cart);
	}
	
}
