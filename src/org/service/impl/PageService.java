package org.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.dao.impl.PageDao;
import org.entity.Page;
import org.entity.PageDivide;
import org.junit.Test;

import cn.itcast.commons.CommonUtils;

public class PageService {
	
	PageDao dao = new PageDao();
	
	public PageDivide getPageDivide(Map<String, String[]> map) throws SQLException{
		PageDivide divide =CommonUtils.toBean(map, PageDivide.class);
		List pageList =dao.limitTitle(divide.getPageCode());
		long total = dao.countPage();
		divide.setTotalRecored(total);
		divide.setPageList(pageList);
		return divide;
	}
	
	public JSONObject getPageinfo(JSONObject json) throws SQLException{
		long total = dao.countPage();
		json.put("total", total);
		json.put("distinct", dao.distinct());
		return json;
	}

	public PageDivide getProperty(Map<String, String[]> map,String property) throws SQLException {
		PageDivide divide =CommonUtils.toBean(map, PageDivide.class);
		Page page = new Page();
		page.setProperty(property);
		divide.setTotalRecored(dao.countProperty(page));
		divide.setPageList(dao.getPageList(divide.getPageCode(), page));
		return divide;
	}
	
	public PageDivide getFind(Map<String, String[]> map,String title) throws SQLException {
		PageDivide divide =CommonUtils.toBean(map, PageDivide.class);
		Page page = new Page();
		page.setTitle(title);
		divide.setTotalRecored(dao.countfind(page));
		divide.setPageList(dao.getfind(divide.getPageCode(), page));
		return divide;
	}
	
	public Page getPage(Page page) throws SQLException {
		dao.addCount(page);
		page=dao.getPage(page);
		return page;
	}
	
	public List<Page> getPageList() throws SQLException{
		return dao.getPageList();
	}
}
