package com.sunshine.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.sunshine.dao.CompanyDao;
import com.sunshine.dao.ProjectDao;
import com.sunshine.dao.impl.CompanyDaoImpl;
import com.sunshine.dao.impl.ProjectDaoImpl;
import com.sunshine.util.Util;

public class AddCompanyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	
		int userId = 0;
		String companyName = "";
		int industry = 0;
		String addressLongitude = "";
		String addressLatitude = "";
		String showPage = "";
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String createTime = format.format(date);
		String businessScope = "";
		String showImage = "";
		int image_cnt = 0;
		
		
		DiskFileItemFactory dff = new DiskFileItemFactory();
		ServletFileUpload fu = new ServletFileUpload(dff);

		try {
			List li = fu.parseRequest(request);
			Iterator iter = li.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) { // 此处是判断非文件域，即不是<input
					// type="file"/>的标签
					String name = item.getFieldName(); // 获取form表单中name的id
					if ("companyname".equals(name)) {
						companyName = item.getString("utf-8"); // item是指定id的value值，此处用
						// item.getString("utf-8")是把item用utf-8解析，根据你的需要可以用其他的，如：gbk；
					}
					if ("industry".equals(name)) {
						industry = Integer.valueOf(item.getString("utf-8"));
					}
					if ("address_longitude".equals(name)) {
						addressLongitude = item.getString("utf-8");
					}
					if ("address_latitude".equals(name)) {
						addressLatitude = item.getString("utf-8");
					}
					if ("show_page".equals(name)) {
						showPage = item.getString("utf-8");
					}
					if ("business_scope".equals(name)) {
						businessScope = item.getString("utf-8");
					}
				} else {
//					System.out.println(item.getSize());
					if(item.getSize() > 0){
					image_cnt++;
					Date Ctime = new Date();
					String dirTime = String.valueOf(Ctime.getTime());
					String fileName = dirTime + image_cnt + ".jpg";
					
					String path = getServletContext().getRealPath("/")
							+ "iframe\\images\\company\\";
					
					
					// File file = new File(path + "//" + fileName);
					File IMG_ROOT = new File(path);
//					System.out.println(path);
					if (!IMG_ROOT.exists()) {
						IMG_ROOT.mkdirs();
					}
					path = path + fileName;//存放在服务器的位置
//					System.out.println(path);
					try {
						item.write(new File(path));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					showImage += Util.url+fileName+";";
				}
				}
				
			}
			
			CompanyDao dao = new CompanyDaoImpl();

			boolean flag = dao.add(userId, companyName, addressLongitude, addressLatitude,
					businessScope, industry, showPage, createTime, showImage);
			if (flag) {
				out
						.print("<script>alert('添加新企业成功');location = 'dashboard.jsp';</script>");
			} else {
				out
						.print("<script>alert('添加新企业失败');location = 'dashboard.jsp';</script>");
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
