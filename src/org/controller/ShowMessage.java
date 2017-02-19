package org.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.VisitWordDivide;
import org.service.impl.ShowMessageService;

import cn.itcast.commons.CommonUtils;

@WebServlet("/message")
public class ShowMessage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowMessageService service = new ShowMessageService();
		VisitWordDivide divide = CommonUtils.toBean(request.getParameterMap(), VisitWordDivide.class);
		try {
			divide = service.getDivide(divide);
			request.setAttribute("divide", divide);
			System.out.println(divide);
			request.getRequestDispatcher("/view/message.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
