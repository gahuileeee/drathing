package com.drathing.dto;

public class PrintDTO {
	private String number;
	private String name;
	private String printing;
	private String user;
	private String like;
	@Override
	public String toString() {
		return "PrintDTO [number=" + number + ", name=" + name + ", printing=" + printing + ", user=" + user + ", like="
				+ like + "]";
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrinting() {
		return printing;
	}
	public void setPrinting(String printing) {
		this.printing = printing;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	
	

}
