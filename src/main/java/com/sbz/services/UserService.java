package com.sbz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbz.models.User;
import com.sbz.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User findOneByUsernameAndPassword(String username, String password) {
		return repository.findOneByUsernameAndPassword(username, password);
	}
	
	public User findOneByUsername(String username) {
		return repository.findOneByUsername(username);
	}
}
