package org.entity;

import java.util.Date;

public class Reply {
	
	private int ID;
	private int visitword_id;
	private String word;
	private Date time;
	private User user;
	private int user_id;
	private String to_who;
	private boolean secret;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getVisitword_id() {
		return visitword_id;
	}
	public void setVisitword_id(int visitword_id) {
		this.visitword_id = visitword_id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTo_who() {
		return to_who;
	}
	public void setTo_who(String to_who) {
		this.to_who = to_who;
	}
	public boolean isSecret() {
		return secret;
	}
	public void setSecret(boolean secret) {
		this.secret = secret;
	}
	@Override
	public String toString() {
		return "Reply [ID=" + ID + ", visitword_id=" + visitword_id + ", word="
				+ word + ", time=" + time + ", user=" + user + ", user_id="
				+ user_id + ", to_who=" + to_who + ", secret=" + secret + "]";
	}


}
