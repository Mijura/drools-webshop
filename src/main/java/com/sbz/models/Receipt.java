package com.sbz.models;

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
	
	@Column(nullable = false)
	private double totalPrice;
	
	@Column(nullable = false)
	private double finalPrice;
	
	@Column(nullable = false)
	private int earnedPoints;
	
	@Column(nullable = false)
	private int spentPoints;
	
	@Column(nullable = false)
	private String state;
	
	@OneToMany(mappedBy="receipt", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Item> items;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ReceiptDiscount> discounts;
	
	public Receipt(){}

	public Receipt(Long id, Date date, Customer customer, double totalPrice, double finalPrice, int earnedPoints, int spentPoints,
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getEarnedPoints() {
		return earnedPoints;
	}

	public void setEarnedPoints(int earnedPoints) {
		this.earnedPoints = earnedPoints;
	}

	public int getSpentPoints() {
		return spentPoints;
	}

	public void setSpentPoints(int spentPoints) {
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
