package com.sbz.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Receipt {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private Date date;
	
	@ManyToOne
	private Customer customer;
	
	@Column
	private Double totalPrice;
	
	@Column
	private Double finalPrice;
	
	@Column
	private Integer earnedPoints;
	
	@Column
	private Integer spentPoints;
	
	@Column(nullable = false)
	private String state;
	
	@OneToMany(mappedBy="receipt", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Item> items;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ReceiptDiscount> discounts=new ArrayList<ReceiptDiscount>();
	
	public Receipt(){}

	public Receipt(Long id, Date date, Customer customer, Double totalPrice, Double finalPrice, Integer earnedPoints, Integer spentPoints,
			String state, List<Item> items, List<ReceiptDiscount> discounts) {
		super();
		this.id = id;
		this.date = date;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.finalPrice = finalPrice;
		this.earnedPoints = earnedPoints;
		this.spentPoints = spentPoints;
		this.state = state;
		this.items = items;
		this.discounts = discounts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Integer getEarnedPoints() {
		return earnedPoints;
	}

	public void setEarnedPoints(Integer earnedPoints) {
		this.earnedPoints = earnedPoints;
	}

	public Integer getSpentPoints() {
		return spentPoints;
	}

	public void setSpentPoints(Integer spentPoints) {
		this.spentPoints = spentPoints;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<ReceiptDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<ReceiptDiscount> discounts) {
		this.discounts = discounts;
	}
	
	
}
