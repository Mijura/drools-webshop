package com.sbz.dto;

public class CartDTO {

	private Long id;
	private int amount;
	
	public CartDTO(){}

	public CartDTO(Long id, int amount) {
		this.id = id;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
