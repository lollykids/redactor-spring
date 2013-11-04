package com.lollykids.biz.model;

public class Mail {

	private String subject;
	private String content;
	private boolean me;
	
	public Mail(String subject, String content) {
		this.subject = subject;
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isMe() {
		return me;
	}
	public void setMe(boolean me) {
		this.me = me;
	}
	
	
}
