package com.drathing.dto;

public class KeywordDTO {
	private String seq;
	private String name;
	
	
	
	@Override
	public String toString() {
		return "KeywordDTO [seq=" + seq + ", name=" + name + "]";
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
