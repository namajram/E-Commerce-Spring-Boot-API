package com.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long orderId;
	private double totalPrice;
	@OneToMany(mappedBy = "order",fetch = FetchType.LAZY,orphanRemoval = true)
	@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","orderItem"})
	private OrderItem orderItem;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userOrderId",referencedColumnName = "userId")
	@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","user"})
	private User user;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Order(Long orderId, double totalPrice, OrderItem orderItem, User user) {
		super();
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.orderItem = orderItem;
		this.user = user;
	}
	public Order() {
		super();
	}
	
}
