package com.api.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userName;
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER,orphanRemoval = true)

@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","user"})
	private List<Cart> cart = new ArrayList<>();
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER,orphanRemoval = true)

@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","orders"})
	private List<Order> orders =new ArrayList<>();
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public User() {
		super();
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public User(long userId, String userName, List<Cart> cart, List<Order> orders) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.cart = cart;
		this.orders = orders;
	}
	
	
	
}
