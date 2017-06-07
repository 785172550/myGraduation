package com.sunshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunshine.dao.CompanyDao;
import com.sunshine.dao.ProjectDao;
import com.sunshine.dao.impl.CompanyDaoImpl;
import com.sunshine.dao.impl.ProjectDaoImpl;

public class DeleteProjectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int id = (int) Integer.valueOf(request.getParameter("id"));
		ProjectDao dao = new ProjectDaoImpl();
		boolean flag = dao.delete(id);
		if(flag){
			out.print("<script>alert('删除项目成功');location = 'ShowDeleteProjectServlet';</script>");
		}else{
			out.print("<script>alert('删除项目失败');location = 'ShowDeleteProjectServlet';</script>");
		}
	
		out.flush();
		out.close();
	}
}
