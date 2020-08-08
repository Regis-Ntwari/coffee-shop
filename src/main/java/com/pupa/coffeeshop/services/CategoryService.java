package com.pupa.coffeeshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pupa.coffeeshop.domain.Category;
import com.pupa.coffeeshop.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	public Category addCategory(Category c) {
		return categoryRepository.saveAndFlush(c);
	}
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	public Category getOneCategory(int id) {
		return categoryRepository.getOne(id);
	}
}
