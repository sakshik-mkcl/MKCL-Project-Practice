package com.app.pojos;

public class User {
	
	public Long id;
	public String name;
	public String username;
	public String gender;
	
	public User() {}

	public User(Long id, String name, String username, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", gender="
				+ gender + "]";
	}
	
	
}
