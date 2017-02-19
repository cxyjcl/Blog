package org.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.User;
import org.entity.Visit;
import org.service.impl.VisitService;

import cn.itcast.commons.CommonUtils;

@WebServlet("/visit.do")
public class VisitMessage extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		VisitService service = new VisitService();
		String str = request.getParameter("word");
		if(str.equals("")){
			response.getWriter().println("<script>window.location.href='/Blog/message';alert('文本不得为空!');</script>");
		}
		else{
			try {
				User user =(User) request.getSession().getAttribute("user");
				boolean bool = request.getParameterValues("visitCheckbox")!=null;
				service.addWord(str, user.getUserName(),bool);
				response.sendRedirect("/Blog/message");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
