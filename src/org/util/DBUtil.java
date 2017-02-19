package org.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	//以c3p0.properties为配置，获取连接
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//保证了线程安全，用于事务。
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//获得连接
	public static Connection getConnection() throws SQLException{
		Connection con = tl.get();
		if(con!=null)
			return con;
		return dataSource.getConnection();
	}
	
	//获取连接源
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	//事务开启
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();
		if(con != null)throw new SQLException("已经开启事务了，就不要重复开启了!");
		con = getConnection();
		//手动提交
		con.setAutoCommit(false);
		tl.set(con);
	}

	//提交事务
	public static void commitTransaction() throws SQLException{
		Connection con =tl.get();
		if(con == null)throw new SQLException("没有开启事务，不能提交!");
		con.commit();
		con.close();
		tl.remove();
	}
	
	//事务回滚
	public static void rollbackTransaction() throws SQLException{
		Connection con = tl.get();
		if(con == null) throw new SQLException("还没有开启业务，不能回滚!");
		con.rollback();
		con.close();
		tl.remove();
	}
	
	//释放连接
	public static void releaseConnection(Connection connection) throws SQLException{
		Connection con = tl.get();
		//说明连接不是用于事务的
		if(con == null)
			connection.close();
//		如果con != null，说明有事务，那么需要判断参数连接是否与con相等，
//		若不等，说明参数连接不是事务专用连接
		if(con !=connection)
			connection.close();
	}
}
