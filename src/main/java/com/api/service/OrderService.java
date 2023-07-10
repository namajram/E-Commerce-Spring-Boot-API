package com.api.service;

import java.util.List;

import com.api.entities.Cart;

public interface OrderService {

	List<Cart> checkoutCart(Long userId);

}
