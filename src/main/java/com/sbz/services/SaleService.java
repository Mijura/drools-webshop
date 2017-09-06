package com.sbz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbz.models.Sale;
import com.sbz.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findAll() {
		return repository.findAll();
	}

	public Sale findOne(String id) {
		return repository.findOne(id);
	}

	public void save(Sale sale) {
		repository.save(sale);
		
	}
}
