package com.sbz.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Integer number;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "receipt")
	private Receipt receipt;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "article")
	private Article article;
	
	@Column
	private Double articlePriceOnDay;
	
	@Column
	private Integer amount;
	
	@Column
	private Double totalPrice;
	
	@Column
	private Integer discount;
	
	@Column
	private Double finalPrice;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemDiscount> itemDiscounts = new ArrayList<ItemDiscount>();
	
	public Item(){}

	public Item(Article article, Integer amount) {
		this.article = article;
		this.amount = amount;
		this.articlePriceOnDay = article.getPrice();
		this.totalPrice = this.amount * this.articlePriceOnDay;
	}

	public Item(Long id, Integer number, Receipt receipt, Article article, Double articlePriceOnDay, Integer amount,
			Double totalPrice, Integer discount, Double finalPrice, List<ItemDiscount> itemDiscounts) {
		super();
		this.id = id;
		this.number = number;
		this.receipt = receipt;
		this.article = article;
		this.articlePriceOnDay = articlePriceOnDay;
		this.amount = amount;
		this.totalPrice = totalPrice;
		this.discount = discount;
		this.finalPrice = finalPrice;
		this.itemDiscounts = itemDiscounts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Double getArticlePriceOnDay() {
		return articlePriceOnDay;
	}

	public void setArticlePriceOnDay(Double articlePriceOnDay) {
		this.articlePriceOnDay = articlePriceOnDay;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public List<ItemDiscount> getItemDiscounts() {
		return itemDiscounts;
	}

	public void setItemDiscounts(List<ItemDiscount> itemDiscounts) {
		this.itemDiscounts = itemDiscounts;
	}

	
	
	
}
