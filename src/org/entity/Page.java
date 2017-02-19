package org.entity;

import java.util.Date;



public class Page {
	
	private int ID;
	private String title;
	private Date time;
	private int click;
	private String content;
	private String property;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	@Override
	public String toString() {
		return "Page [ID=" + ID + ", title=" + title + ", time=" + time
				+ ", click=" + click + ", content=" + content + ", property="
				+ property + "]";
	}

	
}
