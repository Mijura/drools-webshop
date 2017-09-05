package com.sbz.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private Name name;
	
	@OneToMany
	private List<SpendingLimit> limits;

	public Category(){}

	public Category(Long id, Name name, ArrayList<SpendingLimit> limits) {
		super();
		this.id = id;
		this.name = name;
		this.limits = limits;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
	public void setLimits(List<SpendingLimit> limits) {
		this.limits = limits;
	}

	public List<SpendingLimit> getLimits() {
		return limits;
	}
	
}
