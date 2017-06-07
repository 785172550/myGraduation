package com.sunshine.dao;

import java.util.List;

import com.sunshine.entity.Company;
import com.sunshine.entity.Project;

public interface ProjectDao {

	public boolean add(String title, String time, int launcherId, int favorite,
			String coverImage, String detailsPage, String createTime);

	/**
	 * 删除
	 * 
	 */
	public boolean delete(int id);

	public Project update(int id, String title, String time, int launcherId,
			int favorite, String coverImage, String detailsPage);

	/**
	 * 通过ID获取项目信息
	 * 
	 * @param id
	 * @return
	 */
	public Project getProjectByID(int id);

	/**
	 * 
	 * 获得所有项目信息
	 * 
	 * @return
	 */
	public List<Project> getAllProject();

}
