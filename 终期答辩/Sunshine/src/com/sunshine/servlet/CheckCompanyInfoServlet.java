package com.sunshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunshine.dao.CompanyDao;
import com.sunshine.dao.impl.CompanyDaoImpl;
import com.sunshine.entity.Company;

public class CheckCompanyInfoServlet extends HttpServlet {

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
//		System.out.println(id);
		CompanyDao dao = new CompanyDaoImpl();
		
		Company company = dao.getCompanyByID(id);
		String photoPath = company.getShow_Photo();
		String[] pathlist = photoPath.split("\\;");
		for (int i = 0; i < pathlist.length; i++) {
//			System.out.println(pathlist[i]);
		}
//		System.out.println(company.toString());
		request.setAttribute("company", company);
		request.setAttribute("pathlist", pathlist);
		request.getRequestDispatcher("CheckCompanyInfo.jsp").forward(request,
					response);
		out.flush();
		out.close();
	}

}
