package com.sbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbz.models.ArticleCategory;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, String>{

	
}
