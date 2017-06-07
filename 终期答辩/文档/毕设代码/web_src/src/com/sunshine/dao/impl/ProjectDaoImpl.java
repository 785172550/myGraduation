package com.sunshine.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunshine.dao.ProjectDao;
import com.sunshine.entity.Project;
import com.sunshine.util.DbCon;

public class ProjectDaoImpl implements ProjectDao {

	public boolean add(String title, String time, int launcherId, int favorite,
			String coverImage, String detailsPage, String createTime) {
		DbCon con = new DbCon();

		return con
				.update(
						"insert into project(title,time,launcher_id,favorite,cover_image,details_page,create_time) values(?,?,?,?,?,?,?)",
						title, time, launcherId, favorite, coverImage,
						detailsPage, createTime);
	}

	public boolean delete(int id) {
		DbCon con = new DbCon();
		return con.update("delete from project where id=?", id);
	}

	public List<Project> getAllProject() {
		DbCon con = new DbCon();
		List<Project> list = new ArrayList<Project>();
		ResultSet rs = con.query("select * from project");
		try {
			while (rs.next()) {
				Project project = new Project();
				project = (Project) getProjectByID(rs.getInt("id"));
				list.add(project);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.closeAll();
		}
		return list;
	}

	public Project getProjectByID(int id) {
		DbCon con = new DbCon();
		Project project = null;
		ResultSet rs = con.query("select * from project where id=?", id);
		try {
			if (rs.next()) {
				project = new Project();
				project.setId(rs.getInt("id"));
				project.setTitle(rs.getString("title"));
				project.setTime(rs.getString("time"));
				project.setLauncher_id(rs.getInt("launcher_id"));
				project.setFavorite(rs.getInt("favorite"));
				project.setCreate_time(rs.getString("create_time"));
				project.setCover_image(rs.getString("cover_image"));
				project.setDetails_page(rs.getString("details_page"));
			}
			
			//获取launcher_id的名字
			int launcher_id = project.getLauncher_id();
			
			ResultSet rs2 = con.query("select name from user where id=?", launcher_id);
			if (rs2.next()) {
				project.setLauncher_name(rs2.getString("name"));
			}else{
				project.setLauncher_name("管理员");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.closeAll();
		}

		return project;
	}
	
	public Project update(int id, String title, String time, int launcherId,
			int favorite, String coverImage, String detailsPage) {
		DbCon con = new DbCon();
		boolean flag = con
				.update(
						"update project set title=? , time=?,launcher_id=?, favorite=?, cover_image=?, details_page=? where id=?",
						title, time, launcherId, favorite, coverImage,
						detailsPage, id);

		if (flag) {
			return getProjectByID(id);
		}
		return null;
	}
}
