package org.service.impl;

import java.sql.SQLException;

import org.dao.impl.ReplyDao;

public class ReplyRemoveService {

	ReplyDao dao = new ReplyDao();
	public void removeWord(int ID) throws SQLException {
		dao.deleteWord(ID);
	}

}
