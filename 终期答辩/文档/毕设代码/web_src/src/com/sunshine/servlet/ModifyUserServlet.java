package com.sunshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunshine.dao.UserDao;
import com.sunshine.dao.impl.UserDaoImpl;
import com.sunshine.entity.User;

public class ModifyUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		int id = Integer.valueOf(request.getParameter("id"));
		UserDao dao = new UserDaoImpl();
		User user= dao.getUserByID(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("ModifyUserInfo.jsp").forward(request,
				response);
		out.flush();
		out.close();
	}

}
