package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.User;
import org.service.impl.MailService;
import org.util.MailUtil;
import org.util.SecurityUtil;

import cn.itcast.commons.CommonUtils;
@WebServlet("/Email.do")
public class SendEmail extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		MailService mail = new MailService();
		String content = request.getParameter("content");
		try {
			if(!mail.find(user)){
				response.getWriter().println("邮箱与用户名不匹配!");
			}
			else{
				mail.send(user,content);
				response.getWriter().println("发送成功!请查收");
			}
		} catch (SQLException | MessagingException e) {
			// TODO Auto-generated catch block
			response.getWriter().println("发送失败，请重新发送");
			e.printStackTrace();
		}
	}

}
