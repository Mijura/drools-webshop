package com.sbz.dto;

import com.sbz.models.Article;

public class NewDTO {

	private int newValue;
	private Article article;
	
	public NewDTO(){}

	public NewDTO(int newValue, Article article) {
		super();
		this.newValue = newValue;
		this.article = article;
	}

	public int getNewValue() {
		return newValue;
	}

	public void setNewValue(int newValue) {
		this.newValue = newValue;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}
