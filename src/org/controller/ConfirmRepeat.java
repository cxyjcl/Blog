package org.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.impl.CheckNameImpl;
import org.entity.User;
import org.service.LSEService;
import org.service.impl.CheckEmailServiceImpl;
import org.service.impl.CheckNameServiceImpl;
import org.service.impl.SignServiceImpl;

import cn.itcast.commons.CommonUtils;

@WebServlet("/ConfirmRepeat.do")
public class ConfirmRepeat extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
    	LSEService checkName = new CheckNameServiceImpl();
    	LSEService checkEmail = new CheckEmailServiceImpl();
    	try {
    		if(!user.getEmail().equals("")){
    			if(checkEmail.find(user)){
    				response.getWriter().println("邮箱重复!");
    			}
    			else{
    				response.getWriter().println(" ");
    			}
    		}
    		if(!user.getUserName().equals("")){
    			if(checkName.find(user)){
    				response.getWriter().println("用户名重复!");
    			}
    			else{
    				response.getWriter().println(" ");
    			}
    		}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("添加数据失败!");
		}
	}

}
