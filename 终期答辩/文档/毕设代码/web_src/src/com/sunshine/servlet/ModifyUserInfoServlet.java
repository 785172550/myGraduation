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

public class ModifyUserInfoServlet extends HttpServlet {

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
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		int sex = Integer.valueOf(request.getParameter("sex"));
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String updateTime = format.format(date);
		String header = null;

		UserDao dao = new UserDaoImpl();

		User user = dao.update(id,username, password, header,phonenumber, name, sex, address,
				updateTime);
	
		out.print("<script>alert('修改用户成功');location = 'dashboard.jsp';</script>");
		
		out.flush();
		out.close();
	}

}
