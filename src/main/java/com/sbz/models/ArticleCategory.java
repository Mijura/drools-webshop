package com.sbz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ArticleCategory {
	
	@Id
	private String id;
	
	@Column
	private String name;
	
	@Column
	private Integer maxDiscount;
	
	@ManyToOne
	private ArticleCategory superCategory;
	
	public ArticleCategory(){}

	public ArticleCategory(String id, String name, Integer maxDiscount, ArticleCategory superCategory) {
		super();
		this.id = id;
		this.name = name;
		this.maxDiscount = maxDiscount;
		this.superCategory = superCategory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(Integer maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	public ArticleCategory getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(ArticleCategory superCategory) {
		this.superCategory = superCategory;
	}
	
	
}
