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
	
	@Column
	private Double fromLimit;
	
	@Column
	private Double toLimit;
	
	@Column
	private Integer priceToPoints;
	
	public SpendingLimit(){}

	public SpendingLimit(Long id, Double fromLimit, Double toLimit, Integer priceToPoints) {
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

	public Double getFromLimit() {
		return fromLimit;
	}

	public void setFromLimit(Double fromLimit) {
		this.fromLimit = fromLimit;
	}

	public Double getToLimit() {
		return toLimit;
	}

	public void setToLimit(Double toLimit) {
		this.toLimit = toLimit;
	}

	public Integer getPriceToPoints() {
		return priceToPoints;
	}

	public void setPriceToPoints(Integer priceToPoints) {
		this.priceToPoints = priceToPoints;
	}

}
