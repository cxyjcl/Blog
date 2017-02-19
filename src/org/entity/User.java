package org.entity;

public class User {
	
	private int ID;
	private String userName;
	private String password;
	private String email;
	private String userProperty="common";
	private String touxiang="/Blog/static/img/foot.png";
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserProperty() {
		return userProperty;
	}
	public void setUserProperty(String userProperty) {
		this.userProperty = userProperty;
	}
	
	public String getTouxiang() {
		return touxiang;
	}
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", userProperty="
				+ userProperty + ", touxiang=" + touxiang + "]";
	}	
}
