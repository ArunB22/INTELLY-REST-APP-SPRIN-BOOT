package com.example.restservice.models;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public String getPassword() {return password;}
	public String getEmail() {
		return email;
	}


}
