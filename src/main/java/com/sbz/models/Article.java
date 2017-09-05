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
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private int count;
	
	@Column(nullable = false)
	private Date created;
	
	@Column(nullable = false)
	private boolean ordered;
	
	@Column(nullable = false)
	private int minCount;
	
	@Column(nullable = false)
	private Status status;
	
	public Article(){}

	public Article(Long id, String name, ArticleCategory category, double price, int count, Date created,
			boolean ordered, int minCount, Status status) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
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

	public int getMinCount() {
		return minCount;
	}

	public void setMinCount(int minCount) {
		this.minCount = minCount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
