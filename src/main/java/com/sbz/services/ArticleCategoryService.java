package com.sbz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbz.models.ArticleCategory;
import com.sbz.repository.ArticleCategoryRepository;

@Service
public class ArticleCategoryService {

	@Autowired
	private ArticleCategoryRepository repository;
	
	public List<ArticleCategory> findAll() {
		return repository.findAll();
	}

	public void save(ArticleCategory articleCategory) {
		repository.save(articleCategory);
	}

	public ArticleCategory findOneById(String id) {
		return repository.findOneById(id);
	}
}
