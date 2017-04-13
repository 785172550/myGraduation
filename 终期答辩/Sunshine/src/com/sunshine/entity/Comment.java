package com.sunshine.entity;

public class Comment {
	private int id;
	private int project_id;
	private int user_id;
	private String content;
	private String create_time;

	public Comment(int id, int projectId, int userId, String content,
			String createTime) {
		super();
		this.id = id;
		project_id = projectId;
		user_id = userId;
		this.content = content;
		create_time = createTime;
	}

	public Comment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int projectId) {
		project_id = projectId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int userId) {
		user_id = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String createTime) {
		create_time = createTime;
	}

}
