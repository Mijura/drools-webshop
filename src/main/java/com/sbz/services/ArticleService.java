package com.sbz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbz.models.Article;
import com.sbz.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repository;
	
	public List<Article> findAllByStatus(String status) {
		return repository.findAllByStatus(status);
	}

	public Article findOne(Long id) {
		return repository.findOne(id);
	}

}
