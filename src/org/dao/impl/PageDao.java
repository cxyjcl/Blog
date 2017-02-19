package org.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.entity.Page;
import org.entity.Visit;
import org.junit.Test;
import org.util.TxQueryRunner;

public class PageDao {

	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void addPage(Page page) throws SQLException {		
		QueryRunner qr = new TxQueryRunner();
		String sql = "insert into pageinfo(title,click,time,content,property) values(?,?,?,?,?)";
		Object params[]={page.getTitle(),df.format(page.getTime()),page.getClick(),page.getContent(),page.getProperty()};
		qr.update(sql, params);
	}

	public void deletePage(Page page) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "delete from pageinfo where title=?";
		qr.update(sql, page.getTitle());
	}

	public void updatePage(Page page) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "update pageinfo set title=?,time=?,click=?,content=?,property=? where title='"+page.getTitle()+"'";
		Object params[]={page.getTitle(),page.getTitle(),page.getClick(),page.getContent(),page.getProperty()};
		qr.update(sql, params);
	}
	
	public List<Page> limitTitle(int i) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select title,time,click,property from pageinfo limit "+10*(i-1)+",10";
		return qr.query(sql, new BeanListHandler<Page>(Page.class));
	}
	
	public List<Page> getPageList() throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "SELECT * FROM pageinfo ORDER BY id desc limit 0,3";
		return qr.query(sql, new BeanListHandler<Page>(Page.class));
	}
	
	public void addCount(Page page) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "update pageinfo set click = click+1 where title='"+page.getTitle()+"' and time='"+df.format(page.getTime())+"'";
		qr.update(sql);
	}
	
	public long countPage() throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "select count(*) from pageinfo";
		return qr.query(sql, new ScalarHandler<Long>());
	}

	public Long countProperty(Page page) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "select count(*) from pageinfo where property='"+page.getProperty()+"'";
		return qr.query(sql, new ScalarHandler<Long>());
	}

	public Page getPage(Page page) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select *from pageinfo where title='"+page.getTitle()+"' and time='"+df.format(page.getTime())+"'";
		return qr.query(sql, new BeanHandler<Page>(Page.class));
	}
	
	public List<Page> getPageList(int i,Page page) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select title,click,property,time from pageinfo where property='"+page.getProperty()+"' limit "+10*(i-1)+",10";
		return qr.query(sql, new BeanListHandler<Page>(Page.class));
	}
	
	public List distinct() throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select property,count(*) count from pageinfo group by property having count(property) > 0";
		return qr.query(sql, new MapListHandler());
	}
	
	public Long countfind(Page page) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "select count(*) from pageinfo where title='"+page.getTitle()+"'";
		return qr.query(sql, new ScalarHandler<Long>());
	}

	public List<Page> getfind(int i,Page page) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select title,click,property,time from pageinfo where title='"+page.getTitle()+"' limit "+10*(i-1)+",10";
		return qr.query(sql, new BeanListHandler<Page>(Page.class));
	}
}
