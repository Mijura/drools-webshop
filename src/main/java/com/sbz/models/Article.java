package com.sbz.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	ArticleCategory category;
	
	@Column
	private Double price;
	
	@Column
	private Integer count;
	
	@Column
	private Date created;
	
	@Column
	private boolean ordered;
	
	@Column
	private Integer minCount;
	
	@Column
	private String status;
	
	public Article(){}

	public Article(Long id, String name, ArticleCategory category, Double price, Integer count, Date created,
			boolean ordered, Integer minCount, String status) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.count = count;
		this.created = created;
		this.ordered = ordered;
		this.minCount = minCount;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArticleCategory getCategory() {
		return category;
	}

	public void setCategory(ArticleCategory category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public Integer getMinCount() {
		return minCount;
	}

	public void setMinCount(Integer minCount) {
		this.minCount = minCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
