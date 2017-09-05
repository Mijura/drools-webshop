package com.sbz.models;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Salesman extends User {

	public Salesman() {
		super();
	}

	public Salesman(String username, String password, String firstName, String lastName, Date registered) {
		super(username, password, firstName, lastName, registered);
	}
}
