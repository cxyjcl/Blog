package org.dao;

import java.sql.SQLException;

import org.entity.User;

public interface UserDao {
	
	public void addUser(User user) throws SQLException;
	
	public void deleteUser(User user) throws SQLException;
	
	public void updateUser(User user) throws SQLException;
	
	public boolean findUser(User user) throws SQLException;
	
	public User getUser(User user) throws SQLException;
	
	public int getUserID(String str) throws SQLException;
}
