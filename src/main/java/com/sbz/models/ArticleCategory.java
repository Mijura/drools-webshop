package com.sbz.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "articleCategories", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Sale> sales;
	
	public ArticleCategory(){}

	public ArticleCategory(String id, String name, Integer maxDiscount, ArticleCategory superCategory, ArrayList<Sale> sales) {
		super();
		this.id = id;
		this.name = name;
		this.maxDiscount = maxDiscount;
		this.superCategory = superCategory;
		this.sales = sales;
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

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
	
	
	
}
