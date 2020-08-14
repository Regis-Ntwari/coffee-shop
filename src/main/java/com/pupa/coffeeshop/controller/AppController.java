package com.pupa.coffeeshop.controller;

import java.io.File;


import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pupa.coffeeshop.domain.Category;
import com.pupa.coffeeshop.domain.Order;
import com.pupa.coffeeshop.domain.OrderHelper;
import com.pupa.coffeeshop.domain.OrderProduct;
import com.pupa.coffeeshop.domain.Product;
import com.pupa.coffeeshop.services.CategoryService;
import com.pupa.coffeeshop.services.OrderProductService;
import com.pupa.coffeeshop.services.OrderService;
import com.pupa.coffeeshop.services.ProductService;
import com.pupa.coffeeshop.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class AppController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderProductService orderProductService;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public OrderProductService getOrderProductService() {
		return orderProductService;
	}
	public void setOrderProductService(OrderProductService orderProductService) {
		this.orderProductService = orderProductService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//category API
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category category) {
		return this.categoryService.addCategory(category);
	}
	@GetMapping("/categories")
	public List<Category> allCategories(){
		return this.categoryService.allCategories();
	}
	@PutMapping("/category")
	public Category updateCategory(@RequestBody Category category) {
		return this.categoryService.addCategory(category);
	}
	@GetMapping("/category/{id}")
	public Category oneCategory(@PathVariable int id) {
		return this.categoryService.getOneCategory(id);
	}
	
	//product API
	@PostMapping("/product")
	public Product addProduct(@RequestParam MultipartFile multipartFile,
								@RequestParam String name,
								@RequestParam int catId,
								@RequestParam double price) {
		System.out.println("hey there");
		System.out.println(name + " " + catId + " " + price);
		File fileToSave = new File("/home/regis/images/" + name + ".jpg");
		try {
			multipartFile.transferTo(fileToSave);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product pr = new Product();
		pr.setCategory(new Category(catId));
		pr.setName(name);
		pr.setPrice(price);
		pr.setPhoto(name + ".jpg");
		return this.productService.addProduct(pr);
	}
	@PutMapping("/product")
	public Product updateProduct(@RequestParam MultipartFile multipartFile,
			@RequestParam String name,
			@RequestParam int catId,
			@RequestParam double price) {
		System.out.println("hey there");
		System.out.println(name + " " + catId + " " + price);
		File fileToSave = new File("/home/regis/images/" + name + ".jpg");
		try {
			multipartFile.transferTo(fileToSave);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product pr = new Product();
		pr.setCategory(new Category(catId));
		pr.setName(name);
		pr.setPrice(price);
		pr.setPhoto(name + ".jpg");
		return this.productService.addProduct(pr);
	}
	@GetMapping("/products")
	public List<Product> allProducts(){
		return this.productService.allProducts();
	}
	@GetMapping("/product/{id}")
	public Product oneProduct(@PathVariable int id) {
		return this.productService.getOneProduct(id).get();
	}
	@PostMapping("/order")
	public List<OrderProduct> saveOrder(@RequestBody List<OrderHelper> oh){
		List<OrderProduct> trans = new ArrayList<>();
		Order o = new Order();
		o.setDate(Date.valueOf(LocalDate.now()));
		for(OrderHelper ot : oh) {
			trans.add(new OrderProduct(o, productService.getOneProduct(ot.getProductId()).get(), ot.getQuantity()));
		}
		orderProductService.addOrderProduct(trans);
		return trans;
	}
	@GetMapping("/orders")
	public List<Order> allOrder(){
		return orderService.allOrders();
	}
	@GetMapping("/order/{id}")
	public List<OrderProduct> getOneOrder(@PathVariable("id") int id) {
		return orderProductService.allOrdersProduct(id);
	}
}
