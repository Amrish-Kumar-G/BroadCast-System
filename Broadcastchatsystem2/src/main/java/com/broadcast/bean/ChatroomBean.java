package com.broadcast.bean;

public class ChatroomBean {
	private String sender;
	private String message;
	
	public ChatroomBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChatroomBean(String sender, String message) {
		super();
		this.sender = sender;
		this.message = message;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
