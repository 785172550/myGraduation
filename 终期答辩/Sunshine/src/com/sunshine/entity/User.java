package com.sunshine.entity;

public class User {
	private int id;
	private String username;
	private String password;
	private String phonenumber;
	private String header;
	private String name;
	private int sex;
	private String address;
	private int service_team;
	private String create_time;
	private String update_time;
	
	public User(int id, String username, String password, String phonenumber,
			String header, String name, int sex, String address,
			int serviceTeam, String createTime, String updateTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.header = header;
		this.name = name;
		this.sex = sex;
		this.address = address;
		service_team = serviceTeam;
		create_time = createTime;
		update_time = updateTime;
	}

	

	public User() {
		super();
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getService_team() {
		return service_team;
	}

	public void setService_team(int serviceTeam) {
		service_team = serviceTeam;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String createTime) {
		create_time = createTime;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String updateTime) {
		update_time = updateTime;
	}

}
