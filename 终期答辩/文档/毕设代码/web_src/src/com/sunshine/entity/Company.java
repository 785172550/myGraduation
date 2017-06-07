package com.sunshine.entity;

public class Company {
	private int id;
	private int user_id;
	private String company_name;
	private String address_longitude;
	private String address_latitude;
	private String business_scope;
	private int industry;
	private String create_time;
	private String show_photo;
	private String introduction;

	public Company(int id, int userId, String companyName,
			String addressLongitude, String addressLatitude,
			String businessScope, int industry, String introduction,
			String createTime, String showPhoto) {
		super();
		this.id = id;
		user_id = userId;
		company_name = companyName;
		address_longitude = addressLongitude;
		address_latitude = addressLatitude;
		business_scope = businessScope;
		this.industry = industry;
		this.introduction = introduction;
		create_time = createTime;
		show_photo = showPhoto;
	}

	public String getShow_Photo() {
		return show_photo;
	}

	public void setShow_Photo(String showPhoto) {
		show_photo = showPhoto;
	}


	public Company() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int userId) {
		user_id = userId;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String companyName) {
		company_name = companyName;
	}

	public String getAddress_longitude() {
		return address_longitude;
	}

	public void setAddress_longitude(String addressLongitude) {
		address_longitude = addressLongitude;
	}

	public String getAddress_latitude() {
		return address_latitude;
	}

	public void setAddress_latitude(String addressLatitude) {
		address_latitude = addressLatitude;
	}

	public String getBusiness_scope() {
		return business_scope;
	}

	public void setBusiness_scope(String businessScope) {
		business_scope = businessScope;
	}

	public int getIndustry() {
		return industry;
	}

	public void setIndustry(int industry) {
		this.industry = industry;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String createTime) {
		create_time = createTime;
	}

	@Override
	public String toString() {
		return "Company [address_latitude=" + address_latitude
				+ ", address_longitude=" + address_longitude
				+ ", business_scope=" + business_scope + ", company_name="
				+ company_name + ", create_time=" + create_time + ", id=" + id
				+ ", industry=" + industry + ", introduction=" + introduction
				+ ", show_photo=" + show_photo + ", user_id=" + user_id + "]";
	}

}
