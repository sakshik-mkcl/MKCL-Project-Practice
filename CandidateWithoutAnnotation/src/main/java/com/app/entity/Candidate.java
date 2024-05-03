
package com.app.entity;

import java.util.Set;

public class Candidate {
	private int id;
	private String name;
	private String username;
	private String password;
	private String description;
	private Gender gender;
	private Set<Skills> skills;
	private String standard;
	private Set<ProgLang> prolang;
	private File file;
	
	
	public Candidate() {
		
	}


	public Candidate(int id, String name, String username, String password, String description, Gender gender,
			Set<Skills> skills, String standard, Set<ProgLang> prolang, File file) {
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
		this.file = file;
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


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public Set<Skills> getSkills() {
		return skills;
	}


	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}


	public String getStandard() {
		return standard;
	}


	public void setStandard(String standard) {
		this.standard = standard;
	}


	public Set<ProgLang> getProlang() {
		return prolang;
	}


	public void setProlang(Set<ProgLang> prolang) {
		this.prolang = prolang;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", description=" + description + ", gender=" + gender + ", skills=" + skills + ", standard="
				+ standard + ", prolang=" + prolang + ", file=" + file + "]";
	}


	

	
}
