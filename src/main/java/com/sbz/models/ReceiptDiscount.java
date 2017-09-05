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
	
	@Column(nullable = false)
	private int discount;
	
	@Column(nullable = false)
	Type type;

	public ReceiptDiscount(){}
	
	public ReceiptDiscount(Long id, Receipt receiptDisc, int discount, Type type) {
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

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
}