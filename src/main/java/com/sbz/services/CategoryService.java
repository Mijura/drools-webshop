package com.sbz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbz.models.Category;
import com.sbz.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	public Category findOneByName(String name) {
		return repository.findOneByName(name);
	}

	public List<Category> findAll() {
		return repository.findAll();
	}

}
