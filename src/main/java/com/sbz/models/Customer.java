package com.sbz.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer extends User {

	
	@Column
	private String address;
	
	@Column
	private Integer points;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnore
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

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
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
