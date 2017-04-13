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
import com.sunshine.entity.Company;
import com.sunshine.entity.Project;

public class CheckProjectInfoServlet extends HttpServlet {

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
		String launcher_name = request.getParameter("launcher_name");
//		System.out.println(id);
		ProjectDao dao = new ProjectDaoImpl();

		Project project = dao.getProjectByID(id);
		
		request.setAttribute("launcher_name", launcher_name);
		request.setAttribute("project", project);
		request.getRequestDispatcher("CheckProjectInfo.jsp").forward(request,
				response);
		out.flush();
		out.close();
	}
}
