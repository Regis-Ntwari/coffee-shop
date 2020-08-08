package com.pupa.coffeeshop.repositories;



import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.pupa.coffeeshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
}
