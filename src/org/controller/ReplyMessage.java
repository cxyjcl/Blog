package org.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Reply;
import org.entity.User;
import org.junit.Test;
import org.service.impl.ReplyService;

@WebServlet("/reply.do")
public class ReplyMessage extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ReplyService service = new ReplyService();
		String str = request.getParameter("word");
		String who = request.getParameter("who");
		int visit_id = Integer.parseInt(request.getParameter("visit_id"));
		if(str.equals("")){
			response.getWriter().println("<script>window.location.href='/Blog/message';alert('文本不得为空!');</script>");
		}
		else{
			try {
				User user = (User) request.getSession().getAttribute("user");
				boolean bool = request.getParameterValues("visitCheckbox")!=null;
				Reply reply = new Reply();
				reply.setSecret(bool);
				Date time = new Date();
				reply.setVisitword_id(visit_id);
				reply.setWord(str);
				reply.setTime(time);
				reply.setTo_who(who);
				service.addWord(reply,user.getUserName());
				response.sendRedirect("/Blog/message");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
