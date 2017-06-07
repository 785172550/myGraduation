package com.sunshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunshine.dao.UserDao;
import com.sunshine.dao.impl.UserDaoImpl;
import com.sunshine.entity.User;

public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		int sex = Integer.valueOf(request.getParameter("sex"));
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String createTime=format.format(date);
		String header = null;
		int serviceTeam = 0;
		String updateTime = null;
		
		UserDao dao = new UserDaoImpl();
		
		boolean flag = dao.add(username, password, header,phonenumber, name, sex, address, serviceTeam, createTime, updateTime);
		if(flag){
			out.print("<script>alert('添加新用户成功');location = 'dashboard.jsp';</script>");
		}else{
			out.print("<script>alert('该用户已被注册，请重新添加');location = 'AddUser.jsp';</script>");
		}
		out.flush();
		out.close();
	}

}
