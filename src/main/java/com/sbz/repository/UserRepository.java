package com.sbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbz.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findOneByUsernameAndPassword(String username, String password);

	User findOneByUsername(String username);
	
}
