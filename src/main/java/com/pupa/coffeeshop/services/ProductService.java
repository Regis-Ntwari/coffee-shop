package com.pupa.coffeeshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pupa.coffeeshop.domain.Product;
import com.pupa.coffeeshop.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product addProduct(Product p) {
		return productRepository.saveAndFlush(p);
	}
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	public Optional<Product> getOneProduct(int id) {
		return productRepository.findById(id);
	}
}
