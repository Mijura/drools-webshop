package com.sbz.models;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Manager extends User{

	public Manager() {
		super();
	}

	public Manager(String username, String password, String firstName, String lastName, Date registered) {
		super(username, password, firstName, lastName, registered);
	}
}
