package com.sbz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbz.models.Customer;
import com.sbz.models.Receipt;
import com.sbz.repository.ReceiptRepository;

@Service
public class ReceiptService {

	@Autowired
	private ReceiptRepository repository;

	public void save(Receipt receipt) {
		repository.save(receipt);
	}

	public List<Receipt> findByCustomer(Customer c) {
		return repository.findByCustomer(c);
	}

	public Receipt findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Receipt> findAll() {
		return repository.findAll();
	}
	
}
