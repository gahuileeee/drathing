package com.drathing.dto;

public class UserDTO {
	private String uid;
	private String upassword;
	private String cpassword;

	public void setCpassword(String cpassword) {
		this.cpassword=cpassword;
	}
	public String getCpassword() {
		return cpassword;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", upassword=" + upassword + "]";
	}
}
