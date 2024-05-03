package com.app.entity;

import java.util.Arrays;

public class File {
	int id;
	byte[] filecontent;
	private Candidate candi;
	
	public File() {
		
	}

	public File(int id, byte[] filecontent, Candidate candi) {
		super();
		this.id = id;
		this.filecontent = filecontent;
		this.candi = candi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getFilecontent() {
		return filecontent;
	}

	public void setFilecontent(byte[] filecontent) {
		this.filecontent = filecontent;
	}

	public Candidate getCandi() {
		return candi;
	}

	public void setCandi(Candidate candi) {
		this.candi = candi;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", filecontent=" + Arrays.toString(filecontent) + ", candi=" + candi + "]";
	}
	
	
}
