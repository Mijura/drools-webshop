package com.sbz.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {

	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private int points;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Receipt> receipts;

	public Customer(){
		super();
	}

	public Customer(String username, String password, String firstName, String lastName, String address, Category category) {
		super(username, password, firstName, lastName);
		this.address = address;
		this.points = 0;
		this.category = category;
		this.receipts = new ArrayList<Receipt>();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(List<Receipt> receipts) {
		this.receipts = receipts;
	}
	
	

}
