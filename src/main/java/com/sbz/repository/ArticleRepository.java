package com.sbz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbz.models.Article;

public interface ArticleRepository  extends JpaRepository<Article, Long>{

	List<Article> findAllByStatus(String status);

}
