package org.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.entity.Page;
import org.util.TxQueryRunner;

public class CountDao {

	public void updateCount() throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "update visitcount set count = count+1";
		qr.update(sql);
	}
	
	public int getCount() throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select * from visitcount";
		return qr.query(sql, new ScalarHandler<Integer>());
	}
}
