package org.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.impl.PageDao;
import org.service.impl.PageService;

import net.sf.json.JSONObject;

@WebServlet("/PageInfo.do")
public class DiaryDivide extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = new JSONObject();
		response.setContentType("text/html;charset=UTF-8");
		PageService page = new PageService();
		try {
			json=page.getPageinfo(json);
			response.getWriter().println(json);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
