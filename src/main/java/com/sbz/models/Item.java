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
	
	@Column(nullable = false)
	private int number;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "receipt")
	private Receipt receipt;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "article")
	private Article article;
	
	@Column(nullable = false)
	private double articlePriceOnDay;
	
	@Column(nullable = false)
	private int amount;
	
	@Column(nullable = false)
	private double totalPrice;
	
	@Column(nullable = false)
	private int discount;
	
	@Column(nullable = false)
	private double finalPrice;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemDiscount> itemDiscounts = new ArrayList<ItemDiscount>();
	
	public Item(){}
	
	public Item(Long id, int number, Receipt receipt, Article article, double articlePriceOnDay, int amount,
			double totalPrice, int discount, double finalPrice, List<ItemDiscount> itemDiscounts) {
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

	public Item(Article article, int amount) {
		this.article = article;
		this.amount = amount;
		this.articlePriceOnDay = article.getPrice();
		this.totalPrice = this.amount * this.articlePriceOnDay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
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

	public double getArticlePriceOnDay() {
		return articlePriceOnDay;
	}

	public void setArticlePriceOnDay(double articlePriceOnDay) {
		this.articlePriceOnDay = articlePriceOnDay;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public List<ItemDiscount> getItemDiscounts() {
		return itemDiscounts;
	}

	public void setItemDiscounts(List<ItemDiscount> itemDiscounts) {
		this.itemDiscounts = itemDiscounts;
	}
	
	
	
}
