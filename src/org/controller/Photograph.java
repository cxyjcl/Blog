package org.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.PhotoDivide;
import org.service.impl.PhotoService;

@WebServlet("/photograph")
public class Photograph extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PhotoService service = new PhotoService();
		PhotoDivide photo = null;
		try {
			photo = service.getPhotoDivide(request.getParameterMap());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(photo);
		request.setAttribute("photo", photo);
		request.getRequestDispatcher("/view/photograph.jsp").forward(request,response);
	}

}
