package com.sbz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbz.models.Customer;
import com.sbz.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public Customer findOneByUsername(String username) {
		return repository.findOneByUsername(username);
	}
	
	
}
