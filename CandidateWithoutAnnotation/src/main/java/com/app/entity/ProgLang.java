package com.app.entity;

public class ProgLang {
	int id;
	String name;
	private Candidate candi;
	
	public ProgLang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProgLang(int id, String name, Candidate candi) {
		super();
		this.id = id;
		this.name = name;
		this.candi = candi;
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

	public Candidate getCandi() {
		return candi;
	}

	public void setCandi(Candidate candi) {
		this.candi = candi;
	}

	@Override
	public String toString() {
		return "ProgLang [id=" + id + ", name=" + name + ", candi=" + candi + "]";
	}
	
	

}
