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

public class AddProjectServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	
		String title = null;
		String time = null;
		int launcherId =0;
		int favorite = 0;
		String coverImage = null;
		String detailsPage = null;
	
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String createTime = format.format(date);
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
					if ("title".equals(name)) {
						title = item.getString("utf-8"); // item是指定id的value值，此处用
						// item.getString("utf-8")是把item用utf-8解析，根据你的需要可以用其他的，如：gbk；
					}
					if ("time".equals(name)) {
						time = item.getString("utf-8"); // item是指定id的value值，此处用
						// item.getString("utf-8")是把item用utf-8解析，根据你的需要可以用其他的，如：gbk；
					}

					if ("details_page".equals(name)) {
						detailsPage = item.getString("utf-8");
						String head = "<head><meta http-equiv=\"content-type\" content=\"text/html;charset=gbk\"/></head>";
						detailsPage = "<html>"+head+"<body>" + detailsPage + "</body></html>";
//						System.out.println(detailsPage);
						Date Dtime = new Date();
						String details_dirTime = String.valueOf(Dtime.getTime());
						String fileName = details_dirTime + ".html";
						String html_path = getServletContext().getRealPath("/")
								+ "iframe\\htmlfiles\\";
						// File file = new File(path + "//" + fileName);
						File ROOT = new File(html_path);
						if (!ROOT.exists()) {
							ROOT.mkdirs();
						}
						String html_path2 = html_path+"\\" + fileName;
						File HTML_ROOT = new File(html_path2);
						if (!HTML_ROOT.exists()) {
							HTML_ROOT.createNewFile();
						}
						byte bytes[] = new byte[51200];
						bytes = detailsPage.getBytes(); // 新加的
//						int b = detailsPage.length(); // 改
						FileOutputStream fos = new FileOutputStream(HTML_ROOT);
						fos.write(bytes);
						fos.close();
						
						//获取富文本编辑后的内容的html文件的服务器位置
						detailsPage = Util.url_html+fileName;
					}
				} else {
					Date Ctime = new Date();
					String dirTime = String.valueOf(Ctime.getTime());
					String fileName = dirTime + ".jpg";
					String path = getServletContext().getRealPath("/")
							+ "iframe\\images\\company\\";
					// File file = new File(path + "//" + fileName);
					File IMG_ROOT = new File(path);
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
					coverImage = Util.url+fileName;
				}
				
			}
			
			ProjectDao dao = new ProjectDaoImpl();

			boolean flag = dao.add(title, time, launcherId, favorite, coverImage, detailsPage, createTime);
			if (flag) {
				out
						.print("<script>alert('添加新项目成功');location = 'dashboard.jsp';</script>");
			} else {
				out
						.print("<script>alert('添加新项目失败');location = 'dashboard.jsp';</script>");
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
