package com.sbz.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ItemDiscount {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Item item;
	
	@Column
	private Integer discount;
	
	@Column
	String type;

	public ItemDiscount(){}
	
	public ItemDiscount(Long id, Item item, Integer discount, String type) {
		super();
		this.id = id;
		this.item = item;
		this.discount = discount;
		this.type = type;
	}
	
	public ItemDiscount(Item item, Integer discount, String type) {
		super();
		this.item = item;
		this.discount = discount;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
