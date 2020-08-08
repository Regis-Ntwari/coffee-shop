package com.pupa.coffeeshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pupa.coffeeshop.domain.User;
import com.pupa.coffeeshop.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public User addUser(User u) {
		return userRepository.saveAndFlush(u);
	}
	public List<User> allUsers(){
		return userRepository.findAll();
	}
	public User getOneUser(String username) {
		return userRepository.getOne(username);
	}
	
}
