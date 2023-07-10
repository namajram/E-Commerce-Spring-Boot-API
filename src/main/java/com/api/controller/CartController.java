package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.Cart;
import com.api.service.impl.CartServiceImpl;

@RestController
public class CartController {
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
@PostMapping("/cart/{productId}/{userId}")
	public ResponseEntity<Cart> addCart(@PathVariable Long productId, @PathVariable Long userId) {
	
	
	Cart addCart = cartServiceImpl.addCart(productId, userId);
	return ResponseEntity.ok(addCart);
}}