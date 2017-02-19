package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Page;
import org.service.impl.PageService;

import cn.itcast.commons.CommonUtils;
@WebServlet("/Content")
public class Content extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		request.setCharacterEncoding("UTF-8");
		String str=request.getParameter("time");
		String url = request.getHeader("referer");
		if(url==null)
			url="/Blog/diary";
		Date date = null;
		try {
			date = df.parse(str);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Page page = CommonUtils.toBean(request.getParameterMap(), Page.class);
		page.setTime(date);
		PageService pageService = new PageService();
		try {
			page =pageService.getPage(page);
			request.setAttribute("page", page);
			request.setAttribute("referer", url);
			request.getRequestDispatcher("/view/content.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
