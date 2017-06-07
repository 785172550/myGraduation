package com.sunshine.dao;

import java.util.List;

import com.sunshine.entity.User;

public interface UserDao {
	/**
	 * 
	 * 判断用户是否存在
	 * @param username
	 * @return
	 */
	public boolean userExist(String username);
	
	
	/**
	 * 修改用户信息
	 * 
	 * @param id
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User update(int id, String username, String password, String header,String phonenumber,
			String name, int sex, String address,String updateTime);

	/**
	 * 通过ID获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User getUserByID(int id);

	/**
	 * 获取总条数
	 */
	public int getUserCount();

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 *            请求第几页
	 * @param size
	 *            请求的条数
	 * @return
	 */
	public List<User> getPageByUser(int page, int size);

	/**
	 * 
	 * 获得所有用户信息
	 * @return
	 */
	public List<User> getAllUser();

	public boolean delete(int id);
	
	public boolean add(String username, String password, String header,String phonenumber,
			String name, int sex, String address, int serviceTeam,
			String createTime, String updateTime);

}
