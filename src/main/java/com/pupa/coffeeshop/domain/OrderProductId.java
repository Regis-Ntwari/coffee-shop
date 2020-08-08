package com.pupa.coffeeshop.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProductId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int orderId;
	private int productId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
