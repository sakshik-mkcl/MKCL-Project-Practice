package com.app.entity;

public class City {
	int id;
	int stateId;
	int countryId;
	String name;
	
	public City() {
		
	}

	public City(int id, int stateId, int countryId, String name) {
		super();
		this.id = id;
		this.stateId = stateId;
		this.countryId = countryId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
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
		return "City [id=" + id + ", stateId=" + stateId + ", countryId=" + countryId + ", name=" + name + "]";
	}
	
	

}
