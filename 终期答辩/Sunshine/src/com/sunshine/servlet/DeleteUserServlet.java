package com.sunshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunshine.dao.UserDao;
import com.sunshine.dao.impl.UserDaoImpl;
import com.sunshine.entity.User;

public class DeleteUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int id = (int)Integer.valueOf(request.getParameter("id"));
		UserDao dao = new UserDaoImpl();
		boolean flag = dao.delete(id);
		if(flag){
			out.print("<script>alert('删除用户成功');location = 'ShowDeleteUserServlet';</script>");
		}else{
			out.print("<script>alert('删除用户失败');location = 'ShowDeleteUserServlet';</script>");
		}
	
		out.flush();
		out.close();
	}

}
