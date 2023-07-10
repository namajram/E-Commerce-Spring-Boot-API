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

public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderItemId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderAndOrderItemId",referencedColumnName = "orderId")
	@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","order"})
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productOrderItemId",referencedColumnName = "productId")
	@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","product"})
	private Product product;
	
	
	
}
