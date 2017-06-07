package com.sunshine.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunshine.dao.CompanyDao;
import com.sunshine.entity.Company;
import com.sunshine.entity.User;
import com.sunshine.util.DbCon;

public class CompanyDaoImpl implements CompanyDao {

	public boolean add(int userId, String companyName, String addressLongitude,
			String addressLatitude, String businessScope, int industry,
			String introduction, String createTime,String showPhoto) {

		DbCon con = new DbCon();

		return con
				.update(
						"insert into company(user_id,company_name,address_longitude,address_latitude,business_scope,industry,introduction,create_time,show_photo) values(?,?,?,?,?,?,?,?,?)",
						userId, companyName, addressLongitude, addressLatitude,
						businessScope, industry, introduction, createTime,showPhoto);
	}

	public boolean delete(int id) {
		DbCon con = new DbCon();
		return con.update("delete from company where id = ?", id);
	}

	public List<Company> getAllCompany() {
		DbCon con = new DbCon();
		List<Company> list = new ArrayList<Company>();
		ResultSet rs = con.query("select * from company");
		try {
			while (rs.next()) {
				Company company = new Company();
//				System.out.print("id:"+rs.getInt("id"));
				company = (Company)getCompanyByID(rs.getInt("id"));
				list.add(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.closeAll();
		}
		return list;
	}

	public Company getCompanyByID(int id) {
		DbCon con = new DbCon();
		Company company = null;
		ResultSet rs = con.query("select * from company where id=?", id);
		try {
			if (rs.next()) {
				company = new Company();
				company.setId(rs.getInt("id"));
				company.setUser_id(rs.getInt("user_id"));
				company.setIndustry(rs.getInt("industry"));
				company.setIntroduction(rs.getString("introduction"));
				company.setAddress_latitude(rs.getString("address_latitude"));
				company.setAddress_longitude(rs.getString("address_longitude"));
				company.setBusiness_scope(rs.getString("business_scope"));
				company.setCompany_name(rs.getString("company_name"));
				company.setCreate_time(rs.getString("create_time"));
				company.setShow_Photo(rs.getString("show_photo"));
				//System.out.println(company);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.closeAll();
		}

		return company;
	}

	public boolean update(int id, int userId, String companyName,
			String addressLongitude, String addressLatitude,
			String businessScope, int industry, String introduction,String showPhoto) {
		DbCon con = new DbCon();
		return con
				.update(
						"update company set user_id=? , company_name=?,address_longitude=?, address_latitude=?, business_scope=?, industry=?, introduction=?,show_photo=? where id=?",
						userId, companyName, addressLongitude, addressLatitude,
						businessScope, industry, introduction,showPhoto, id);


	}
}
