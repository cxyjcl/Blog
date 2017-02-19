package org.service.impl;

import java.sql.SQLException;

import org.dao.impl.VisitDao;

public class VisitRemoveService {

	VisitDao dao = new VisitDao();
	public void removeWord(int ID) throws SQLException {
		dao.deleteWord(ID);
	}

}
