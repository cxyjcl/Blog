package org.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.entity.User;
import org.service.LSEService;
import org.service.impl.LoginServiceImpl;

import cn.itcast.commons.CommonUtils;
@WebServlet("/Login.do")
public class ConfirmForm extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String verifyCode=request.getParameter("verifyCode").toLowerCase();
        HttpSession session = request.getSession();
        String realCode = session.getAttribute("generateCode").toString().toLowerCase();
		String url = request.getHeader("referer");
        if(!realCode.equals(verifyCode)){
        	response.getWriter().println("验证码不正确");
        }
        else{
        	User user = CommonUtils.toBean(request.getParameterMap(), User.class);
        	try {
        		LSEService service = new LoginServiceImpl();
				if(service.find(user)){
			        Cookie cookie = new Cookie("username", URLEncoder.encode(user.getUserName(), "utf-8"));
			        cookie.setMaxAge(30*60*60*24);
			        response.addCookie(cookie);
			        user=service.get(user);
					session.setAttribute("user", user);
					response.getWriter().println("/Blog/index");
				}
				else{
					response.getWriter().println("密码错误!");
				}
			} catch (SQLException e) {
					e.printStackTrace();
					response.getWriter().println("查询数据库失败!");
			}
        }
	}
}
