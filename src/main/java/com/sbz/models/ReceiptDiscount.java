package com.sbz.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ReceiptDiscount {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Receipt receiptDisc;
	
	@Column
	private Integer discount;
	
	@Column
	String type;

	public ReceiptDiscount(){}
	
	public ReceiptDiscount(Long id, Receipt receiptDisc, Integer discount, String type) {
		super();
		this.id = id;
		this.receiptDisc = receiptDisc;
		this.discount = discount;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Receipt getReceiptDisc() {
		return receiptDisc;
	}

	public void setReceiptDisc(Receipt receiptDisc) {
		this.receiptDisc = receiptDisc;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
