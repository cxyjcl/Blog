package org.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.entity.Page;
import org.entity.User;
import org.entity.Visit;
import org.junit.Test;
import org.util.TxQueryRunner;


public class VisitDao{
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void addWord(Visit visit) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "insert into visitword(word,time,user_id,secret) values(?,?,?,?)";
		Object params[]={visit.getWord(),df.format(visit.getTime()),visit.getUser_id(),visit.isSecret()};
		qr.update(sql, params);
	}

	
	public void deleteWord(int ID) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "delete from visitword where ID=?";
		qr.update(sql, ID);
	}
	
	public List<Visit> limitWord(int i) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select * from visitword limit "+10*(i-1)+",10";
		return qr.query(sql, new BeanListHandler<Visit>(Visit.class));
	}
	
	public List<Visit> getWord() throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "SELECT * FROM visitword ORDER BY id desc limit 0,5";
		return qr.query(sql, new BeanListHandler<Visit>(Visit.class));
	}
	
	public long countWord() throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "select count(*) from visitword";
		return qr.query(sql, new ScalarHandler<Long>());
	}
	
	public User getUser(int ID) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select userName,touxiang from userinfo where id ='"+ID+"'";
		return qr.query(sql, new BeanHandler<User>(User.class));
	}
	
}
