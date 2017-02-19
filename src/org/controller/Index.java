package org.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.impl.CountService;
import org.service.impl.PageService;
import org.service.impl.ShowMessageService;


@WebServlet("/index")
public class Index extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CountService count = new CountService();
    	ShowMessageService message = new ShowMessageService();
    	PageService page = new PageService();
    	try {
			request.setAttribute("count", count.getCount());
			request.setAttribute("visit", message.getVisitList());
			request.setAttribute("page", page.getPageList());
			System.out.println(message.getVisitList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	request.getRequestDispatcher("/view/index.jsp").forward(request, response);
	}

}
