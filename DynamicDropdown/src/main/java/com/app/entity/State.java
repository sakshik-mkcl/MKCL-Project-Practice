package com.app.entity;

public class State {
	int id;
	int countryId;
	String name;
	
	public State() {
		
	}

	public State(int id, int countryId, String name) {
		super();
		this.id = id;
		this.countryId = countryId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", countryId=" + countryId + ", name=" + name + "]";
	}
	
	
	

}
