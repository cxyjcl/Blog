package org.service.impl;

import java.sql.SQLException;

import org.dao.impl.CountDao;

public class CountService {
	
	CountDao dao = new CountDao();

	public void updateCount() throws SQLException{
		dao.updateCount();
	}
	
	public int getCount() throws SQLException{
		return dao.getCount();
	}
}
