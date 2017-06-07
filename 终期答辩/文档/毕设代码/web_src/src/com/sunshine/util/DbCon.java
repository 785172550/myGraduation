package com.sunshine.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbCon {
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/CCLion";
	public static final String name = "root";
	public static final String pwd = "123456";

	Connection con = null; // 连接对象
	PreparedStatement ps = null; // 语句对象
	ResultSet rs = null; // 结果集对象

	/**
	 * 创建连接
	 */
	public Connection getCon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, name, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭所有对象
	 */
	public void closeAll() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 增删改 问题1：不知道会传递几个参数0...n 问题2：不知道会传递的参数是什么类型 object
	 */
	public boolean update(String sql, Object... obj) {
		boolean flag = false;
		con = getCon();

		try {
			ps = con.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}

			flag = ps.executeUpdate() > 0 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return flag;
	}

	public ResultSet query(String sql, Object... obj) {

		con = getCon();
		try {
			ps = con.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}

			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}
}
