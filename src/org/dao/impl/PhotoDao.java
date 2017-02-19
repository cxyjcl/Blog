package org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.entity.Photo;
import org.junit.Test;
import org.util.TxQueryRunner;

public class PhotoDao {

	public void addPicture(Photo picture) throws SQLException {		
		QueryRunner qr = new TxQueryRunner();
		String sql = "insert into photograph(name,smallPhoto,photo,time) values(?,?,?,?)";
		Object params[]={picture.getName(),picture.getSmallPhoto(),picture.getPhoto(),picture.getTime()};
		qr.update(sql, params);
	}
	
	public void deletePicture(Photo picture) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "delete from photograph where name=?";
		qr.update(sql, picture.getName());
	}

	public void updatePicture(Photo picture) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "update photograph set name=?,smallPhoto=?,photo=?,time=? where name='"+picture.getName()+"'";
		Object params[]={picture.getName(),picture.getSmallPhoto(),picture.getPhoto(),picture.getTime()};
		qr.update(sql, params);
	}
	
	public List<Photo> limitTitle(int i) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select * from photograph limit "+18*(i-1)+",18";
		return qr.query(sql, new BeanListHandler<Photo>(Photo.class));
	}
	
	public long countPage() throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "select count(*) from photograph";
		return qr.query(sql, new ScalarHandler<Long>());
	}

	
}
