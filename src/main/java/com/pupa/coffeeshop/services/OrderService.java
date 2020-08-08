package com.pupa.coffeeshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pupa.coffeeshop.domain.Order;
import com.pupa.coffeeshop.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public Order addOrder(Order o) {
		return orderRepository.saveAndFlush(o);
	}
	public List<Order> allOrders(){
		return orderRepository.findAll();
	}
}
