package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Page;
import org.entity.PageDivide;
import org.service.impl.PageService;

import cn.itcast.commons.CommonUtils;

@WebServlet("/diary")
public class Diary extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageService service = new PageService();
		PageDivide divide = null;
		List pageList = null;
		String property = request.getParameter("property");
		String find = request.getParameter("find");
		if (property != null) {
			try {
				divide = service.getProperty(request.getParameterMap(),request.getParameter("property"));
				request.setAttribute("page", divide);
				request.getRequestDispatcher("/view/diary.jsp").forward(request,
						response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (find != null) {
			try {
				divide = service.getFind(request.getParameterMap(),request.getParameter("find"));
				request.setAttribute("page", divide);
				request.getRequestDispatcher("/view/diary.jsp").forward(request,
						response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				divide = service.getPageDivide(request.getParameterMap());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("page", divide);
			request.getRequestDispatcher("/view/diary.jsp").forward(request,
					response);
		}
	}
}
