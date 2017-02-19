package org.entity;

import java.util.Date;
import java.util.List;

public class Visit {
	
	private int ID;
	private String word;
	private Date time;
	private boolean secret;
	private List<Reply> list;
	private int user_id;
	private User user;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public boolean isSecret() {
		return secret;
	}
	public void setSecret(boolean secret) {
		this.secret = secret;
	}
	public List<Reply> getList() {
		return list;
	}
	public void setList(List<Reply> list) {
		this.list = list;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id =user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Visit [ID=" + ID + ", word=" + word + ", time=" + time
				+ ", secret=" + secret + ", list=" + list + ", user_id="
				+ user_id + ", user=" + user + "]";
	}
}
