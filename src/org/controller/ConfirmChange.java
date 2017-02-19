package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.dao.UserDao;
import org.dao.impl.UpdataPassword;
import org.entity.User;
import org.service.impl.CheckKeyServiceImpl;
import org.util.GeetestLib;

import cn.itcast.commons.CommonUtils;

@WebServlet("/Change.do")
public class ConfirmChange extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String key = request.getParameter("key");
    	User user = CommonUtils.toBean(request.getParameterMap(), User.class);
    	CheckKeyServiceImpl check = new CheckKeyServiceImpl();
    	if(check.check(user, key)){
    		UserDao dao = new UpdataPassword();
    		try {
				dao.updateUser(user);
	    		response.getWriter().println("修改成功！");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	    		response.getWriter().println("更新数据库失败!");
			}
    	}
    	else{
    		response.getWriter().println("该邮箱未申请找回密码！");
    	}
	}
}
