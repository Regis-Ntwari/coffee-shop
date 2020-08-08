package com.pupa.coffeeshop.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.pupa.coffeeshop.domain.OrderProduct;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
	public List<OrderProduct> findByOrder(int id);
}
