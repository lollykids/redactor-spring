package com.lollykids.biz.model;

/**
 * @author hdlee
 */
public class User {

	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "User [email=" + email + "]";
	}
	

	public User() {
		super();
	}

	public User(String email) {
		this();
		this.email = email;
	}
	
	
}
