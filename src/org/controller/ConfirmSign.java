package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.User;
import org.service.LSEService;
import org.service.impl.SignServiceImpl;

import cn.itcast.commons.CommonUtils;
@WebServlet("/Sign.do")
public class ConfirmSign extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
    	LSEService service = new SignServiceImpl();
    	try {
			service.add(user);
			response.getWriter().println("添加成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("添加数据失败!");
		}
	}

}
