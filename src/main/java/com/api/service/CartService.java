package com.api.service;

import com.api.entities.Cart;

public interface CartService {

	
	Cart addCart(Long productId, Long userId);

}
