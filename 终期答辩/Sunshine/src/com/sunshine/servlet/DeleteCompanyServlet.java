package com.sunshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunshine.dao.CompanyDao;
import com.sunshine.dao.UserDao;
import com.sunshine.dao.impl.CompanyDaoImpl;
import com.sunshine.dao.impl.UserDaoImpl;

public class DeleteCompanyServlet extends HttpServlet {

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
		CompanyDao dao = new CompanyDaoImpl();
		boolean flag = dao.delete(id);
		if(flag){
			out.print("<script>alert('删除公司成功');location = 'ShowDeleteCompanyServlet';</script>");
		}else{
			out.print("<script>alert('删除公司失败');location = 'ShowDeleteCompanyServlet';</script>");
		}
	
		out.flush();
		out.close();
	}
}
