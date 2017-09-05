package com.sbz.models;

import javax.persistence.Entity;

@Entity
public class Salesman extends User {

	public Salesman() {
		super();
	}

	public Salesman(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}
}
