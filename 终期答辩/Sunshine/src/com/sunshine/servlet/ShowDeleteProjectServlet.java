package com.sunshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

public class ShowDeleteProjectServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		ProjectDao dao = new ProjectDaoImpl();
		List<Project> list = dao.getAllProject();
		if (list.size() > 0) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("DeleteProject.jsp").forward(request,
					response);
		} else {
			out
					.print("<script>alert('获取项目列表失败');location = 'dashboard.jsp';</script>)");
		}
		out.flush();
		out.close();
	}

}
