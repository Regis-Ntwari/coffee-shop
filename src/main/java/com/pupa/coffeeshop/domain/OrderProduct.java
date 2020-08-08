package com.pupa.coffeeshop.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class OrderProduct implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private OrderProductId orderProductId = new OrderProductId();
	@ManyToOne
	@MapsId("orderId")
	private Order order;
	@ManyToOne
	@MapsId("productId")
	private Product product;
	private int quantity;
	
	
	
	public OrderProduct() {
		super();
	}

	public OrderProduct(Order order, Product product, int quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderProductId getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(OrderProductId orderProductId) {
		this.orderProductId = orderProductId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
