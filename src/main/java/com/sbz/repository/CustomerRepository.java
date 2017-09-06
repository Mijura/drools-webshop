package com.sbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbz.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

	Customer findOneByUsername(String username);
}
