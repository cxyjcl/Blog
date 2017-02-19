package org.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.entity.Photo;
import org.entity.Reply;
import org.entity.User;
import org.entity.Visit;
import org.junit.Test;
import org.util.TxQueryRunner;

public class ReplyDao{
	
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void addWord(Reply reply) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "insert into replyword(visitword_id,word,time,user_id,to_who,secret) values(?,?,?,?,?,?)";
		Object params[]={reply.getVisitword_id(),reply.getWord(),df.format(reply.getTime()),reply.getUser_id(),reply.getTo_who(),reply.isSecret()};
		qr.update(sql, params);
	}
	
	public void deleteWord(int ID) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "delete from replyword where ID=?";
		qr.update(sql, ID);
	}
	
	public List<Reply> getReplyWord(int ID) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select * from replyword where visitword_id in(select visitword_id from visitword,replyword where "+ID+"=replyword.visitword_id)";
		return qr.query(sql, new BeanListHandler<Reply>(Reply.class));
	}
	
	
	public User getUser(int ID) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select userName,touxiang from userinfo where id ='"+ID+"'";
		return qr.query(sql, new BeanHandler<User>(User.class));
	}
}
