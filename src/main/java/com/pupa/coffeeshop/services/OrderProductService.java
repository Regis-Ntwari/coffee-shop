package com.pupa.coffeeshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pupa.coffeeshop.domain.OrderProduct;
import com.pupa.coffeeshop.repositories.OrderProductRepository;

@Service
public class OrderProductService {
	@Autowired
	private OrderProductRepository orderProductRepository;

	public OrderProductRepository getOrderProductRepository() {
		return orderProductRepository;
	}

	public void setOrderProductRepository(OrderProductRepository orderProductRepository) {
		this.orderProductRepository = orderProductRepository;
	}
	
	public List<OrderProduct> addOrderProduct(List<OrderProduct> o){
		return orderProductRepository.saveAll(o);
	}
	public List<OrderProduct> allOrdersProduct(int id){
		return orderProductRepository.findByOrderId(id);
	}
	
}
