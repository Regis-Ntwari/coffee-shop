package com.pupa.coffeeshop.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pupa.coffeeshop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
