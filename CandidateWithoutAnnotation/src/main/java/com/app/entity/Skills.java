package com.app.entity;

public class Skills {
int id ;
String name;
private Candidate candi;


public Skills() {
	
}


public Skills(int id, String name, Candidate candi) {
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
	return "Skills [id=" + id + ", name=" + name + ", candi=" + candi + "]";
}


}
