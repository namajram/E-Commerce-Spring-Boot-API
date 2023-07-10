package com.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productCartId",referencedColumnName = "productId")
	@JsonIgnoreProperties(value= { "handler", "hibernateLazyInitializer", "product" })
	private Product product;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserCartId",referencedColumnName = "userId")
	@JsonIgnoreProperties(value= { "handler", "hibernateLazyInitializer", "user" })
	private User user;
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Cart(long cartId, Product product, User user) {
		super();
		this.cartId = cartId;
		this.product = product;
		this.user = user;
	}
	public Cart() {
		super();
	}
	
	
	
}
