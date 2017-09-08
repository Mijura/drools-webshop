package com.sbz.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sale {

	@Id
	private String id;
	
	@Column
	private String name;
	
	@Column
	private Date fromDate;
	
	@Column
	private Date toDate;
	
	@Column
	private Integer discount;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<ArticleCategory> articleCategories;

	public Sale(){}
	
	public Sale(String id, String name, Date fromDate, Date toDate, int discount,
			List<ArticleCategory> articleCategories) {
		super();
		this.id = id;
		this.name = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.discount = discount;
		this.articleCategories = articleCategories;
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

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public List<ArticleCategory> getArticleCategories() {
		return articleCategories;
	}

	public void setArticleCategories(List<ArticleCategory> articleCategories) {
		this.articleCategories = articleCategories;
	}
	
	
}
