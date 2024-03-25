package com.drathing.dto;

public class CommentDTO {
	
	private String pk;
	private String number;
	private String comment_id;
	private String content;
	
	@Override
	public String toString() {
		return "CommentDTO [pk=" + pk + ", number=" + number + ", comment_id=" + comment_id + ", content=" + content
				+ "]";
	}
	
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
