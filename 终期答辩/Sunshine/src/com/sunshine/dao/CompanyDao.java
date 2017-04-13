package com.sunshine.dao;

import java.util.List;

import com.sunshine.entity.Company;
import com.sunshine.entity.User;

public interface CompanyDao {

	/**
	 * 增加公司
	 * @param userId
	 * @param companyName
	 * @param addressLongitude
	 * @param addressLatitude
	 * @param businessScope
	 * @param industry
	 * @param showPage
	 * @param createTime
	 * @return
	 */
	
	public boolean add(int userId, String companyName, String addressLongitude,
			String addressLatitude, String businessScope, int industry,
			String introdution, String createTime,String showPhoto);
	
	/**
	 * 删除
	 * 
	 */
	public boolean delete(int id);

	/**
	 * 
	 * 修改
	 * @param id
	 * @param userId
	 * @param companyName
	 * @param addressLongitude
	 * @param addressLatitude
	 * @param businessScope
	 * @param industry
	 * @param showPage
	 * @return
	 */
	public boolean update(int id, int userId, String companyName,
			String addressLongitude, String addressLatitude,
			String businessScope, int industry, String introdution,String showPhoto);

	/**
	 * 通过ID获取公司信息
	 * 
	 * @param id
	 * @return
	 */
	public Company getCompanyByID(int id);


	/**
	 * 
	 * 获得所有公司信息
	 * 
	 * @return
	 */
	public List<Company> getAllCompany();

}
