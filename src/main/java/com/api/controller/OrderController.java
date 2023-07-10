package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.Cart;
import com.api.service.impl.OrderServiceImpl;

@RestController
public class OrderController {

	@Autowired
	private OrderServiceImpl orderServiceImpl;
	@PostMapping("/order/{userId}")
	public ResponseEntity<List<Cart>> checkoutCart(Long userId) {
		List<Cart> checkoutCart = orderServiceImpl.checkoutCart(userId);
		return ResponseEntity.ok(checkoutCart);}
}
