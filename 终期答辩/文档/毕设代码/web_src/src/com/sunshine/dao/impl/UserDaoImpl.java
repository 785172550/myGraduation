package com.sunshine.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sunshine.dao.UserDao;
import com.sunshine.entity.User;
import com.sunshine.util.DbCon;

public class UserDaoImpl implements UserDao {

	public User getUserByID(int id) {
		DbCon con = new DbCon();
		User user = null;
		ResultSet rs = con.query("select * from user where id=?", id);
		try {
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setCreate_time(rs.getString("create_time"));
				user.setHeader(rs.getString("header"));
				user.setSex(rs.getInt("sex"));
				user.setService_team(rs.getInt("service_team"));
				user.setUpdate_time(rs.getString("update_time"));
				user.setPhonenumber("contact");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.closeAll();
		}

		return user;
	}

	public List<User> getPageByUser(int page, int size) {
		DbCon con = new DbCon();
		List<User> list = new ArrayList<User>();
		ResultSet rs = con.query("select * from user limit "
				+ ((page - 1) * size) + " , " + size);
		try {
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.closeAll();
		}
		return list;
	}

	public int getUserCount() {
		DbCon con = new DbCon();
		int count = 0;
		ResultSet rs = con.query("select count(*) as num from user");
		try {
			if (rs.next()) {
				count = rs.getInt("num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.closeAll();
		}
		return count;
	}

	public boolean delete(int id) {
		DbCon con = new DbCon();
		return con.update("delete from user where id=?", id);

	}

	public List<User> getAllUser() {
		DbCon con = new DbCon();
		List<User> list = new ArrayList<User>();
		ResultSet rs = con.query("select * from user");
		try {
			while (rs.next()) {
				User user = new User();
				user = (User)getUserByID(rs.getInt("id"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.closeAll();
		}
		return list;
	}

	public boolean add(String username, String password, String header,String phonenumber,
			String name, int sex, String address, int serviceTeam,
			String createTime, String updateTime) {
		if(userExist(username)){
			return false;
		}
		DbCon con = new DbCon();
		return con
				.update(
						"insert into user(username,password,header,name,sex,address,service_team,create_time,update_time,contact) values(?,?,?,?,?,?,?,?,?,?)",
						username, password, header, name, sex, address,
						serviceTeam, createTime, updateTime,phonenumber);
	}

	public User update(int id, String username, String password, String header,String phonenumber,
			String name, int sex, String address, String updateTime) {
		DbCon con = new DbCon();
		boolean flag = con
				.update(
						"update user set username=? , password=?,header=?, name=?, sex=?, address=?, update_time=? ,contact=? where id=?",
						username, password, header, name, sex, address,
						updateTime,phonenumber, id);

		if (flag) {
			return getUserByID(id);
		}
		return null;
	}

	public boolean userExist(String username) {
		List<User> userlist = getAllUser();
		for (Iterator<User> it = userlist.iterator();it.hasNext();) {
			if(it.next().getUsername().equals(username)){
				return true;
			}
		}
		return false;
	}
}
