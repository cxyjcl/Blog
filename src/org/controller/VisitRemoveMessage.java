package org.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.impl.VisitRemoveService;
import org.service.impl.VisitService;

@WebServlet("/visitRemove")
public class VisitRemoveMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		VisitRemoveService service = new VisitRemoveService();
		int ID = Integer.parseInt(request.getParameter("ID"));
		try {
			service.removeWord(ID);
			response.sendRedirect("/Blog/message");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
