package org.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/*用于协助QueryRunner处理事务相关的连接
即若为事务连接则释放，
若为普通连接则关闭*/

public class TxQueryRunner extends QueryRunner{

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		Connection con = DBUtil.getConnection();
		int[] result = super.batch(con, sql, params);
		DBUtil.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh)
			throws SQLException {
		Connection con = DBUtil.getConnection();
		T result = super.query(con, sql, param, rsh);
		DBUtil.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh)
			throws SQLException {
		Connection con = DBUtil.getConnection();
		T result = super.query(con, sql, params, rsh);
		DBUtil.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
			throws SQLException {
		Connection con = DBUtil.getConnection();
		T result = super.query(con, sql, rsh, params);
		DBUtil.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = DBUtil.getConnection();
		T result = super.query(con, sql, rsh);
		DBUtil.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con = DBUtil.getConnection();
		int result = super.update(con, sql, params);
		DBUtil.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con = DBUtil.getConnection();
		int result = super.update(con, sql, param);
		DBUtil.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection con = DBUtil.getConnection();
		int result = super.update(con, sql);
		DBUtil.releaseConnection(con);
		return result;
	}
	
}
