package org.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.dao.impl.ReplyDao;
import org.dao.impl.VisitDao;
import org.entity.Reply;
import org.entity.Visit;
import org.entity.VisitWordDivide;
import org.junit.Test;

public class ShowMessageService{
	VisitDao visitDao = new VisitDao();
	ReplyDao replyDao = new ReplyDao();

	public VisitWordDivide getDivide(VisitWordDivide divide)throws SQLException {
		List<Visit> visitList = visitDao.limitWord(divide.getWordCode());
		divide.setWordList(visitList);
		divide.setTotalWord(visitDao.countWord());
		for(Visit visit : visitList){
			List<Reply> replyList = replyDao.getReplyWord(visit.getID());
			for(Reply reply : replyList){
				reply.setUser(replyDao.getUser(reply.getUser_id()));
			}
			visit.setList(replyList);
			visit.setUser(visitDao.getUser(visit.getUser_id()));
		}
		return divide;
	}
	
	public List<Visit> getVisitList() throws SQLException{
		List<Visit> list = visitDao.getWord();
		for(Visit visit : list){
			visit.setUser(visitDao.getUser(visit.getUser_id()));
		}
		return list;
	}
}
