package com.sbz.models;

import javax.persistence.Entity;

@Entity
public class Manager extends User{

	public Manager() {
		super();
	}

	public Manager(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}
}
