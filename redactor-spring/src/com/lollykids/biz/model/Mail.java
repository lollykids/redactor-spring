package com.lollykids.biz.model;

import java.io.Serializable;

public class Mail implements Serializable {

	private static final long serialVersionUID = -2739788642503571077L;
	
	private String subject;
	private String content;
	private String me;
	
	public Mail() {
	}
	
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

	public String getMe() {
		return me;
	}

	public void setMe(String me) {
		this.me = me;
	}

	@Override
	public String toString() {
		return "Mail [subject=" + subject + ", content=" + content + ", me="
				+ me + "]";
	}
	

}
