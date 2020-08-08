package com.pupa.coffeeshop.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.pupa.coffeeshop.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
