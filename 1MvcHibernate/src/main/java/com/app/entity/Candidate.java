package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="candidate")
public class Candidate {
	@Id
	private int id;
	private String name;
	private String username;
	private String password;
	private String description;
	private String gender;
	private String skills;
	private String standard;
	private String prolang;
	private String fileupload;
	
	
	public Candidate() {
		
	}

	

	public Candidate(int id, String name, String username, String password, String description, String gender,
			String skills, String standard, String prolang, String fileupload) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.description = description;
		this.gender = gender;
		this.skills = skills;
		this.standard = standard;
		this.prolang = prolang;
		this.fileupload = fileupload;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public String getStandard() {
		return standard;
	}


	public void setStandard(String standard) {
		this.standard = standard;
	}


	public String getProlang() {
		return prolang;
	}


	public void setProlang(String prolang) {
		this.prolang = prolang;
	}


	public String getFileupload() {
		return fileupload;
	}


	public void setFileupload(String fileupload) {
		this.fileupload = fileupload;
	}


	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", description=" + description + ", gender=" + gender + ", skills=" + skills + ", standard="
				+ standard + ", prolang=" + prolang + ", fileupload=" + fileupload + "]";
	}
	


	
	
	
}
