package org.service;

import java.sql.SQLException;

import org.entity.User;

public interface LSEService {
	
	public boolean find(User user) throws SQLException;
	
	public void add(User user)throws SQLException;
	
	public User get(User user)throws SQLException;
}
