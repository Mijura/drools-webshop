package com.sbz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SpendingLimit {

	@Id
	@GeneratedValue
	Long id;
	
	@Column(nullable = false)
	private double fromLimit;
	
	@Column(nullable = false)
	private double toLimit;
	
	@Column(nullable = false)
	private int priceToPoints;
	
	public SpendingLimit(){}

	public SpendingLimit(Long id, double fromLimit, double toLimit, int priceToPoints) {
		super();
		this.id = id;
		this.fromLimit = fromLimit;
		this.toLimit = toLimit;
		this.priceToPoints = priceToPoints;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getFromLimit() {
		return fromLimit;
	}

	public void setFromLimit(double fromLimit) {
		this.fromLimit = fromLimit;
	}

	public double getToLimit() {
		return toLimit;
	}

	public void setToLimit(double toLimit) {
		this.toLimit = toLimit;
	}

	public int getPriceToPoints() {
		return priceToPoints;
	}

	public void setPriceToPoints(int priceToPoints) {
		this.priceToPoints = priceToPoints;
	}

}
