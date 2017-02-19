package org.entity;

import java.util.Date;

public class Photo {
	
	private String ID;
	private String name;
	private String smallPhoto;
	private String photo;
	private Date time;
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSmallPhoto() {
		return smallPhoto;
	}
	public void setSmallPhoto(String smallPhoto) {
		this.smallPhoto = smallPhoto;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Photo [ID=" + ID + ", name=" + name + ", smallPhoto="
				+ smallPhoto + ", photo=" + photo + ", time=" + time + "]";
	}
	
}