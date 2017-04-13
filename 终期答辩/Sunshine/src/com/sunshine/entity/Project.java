package com.sunshine.entity;

public class Project {
	private int id;
	private String title;
	private String time;
	private int launcher_id;
	private String launcher_name;
	public String getLauncher_name() {
		return launcher_name;
	}

	public void setLauncher_name(String launcherName) {
		launcher_name = launcherName;
	}

	@Override
	public String toString() {
		return "Project [cover_image=" + cover_image + ", create_time="
				+ create_time + ", details_page=" + details_page
				+ ", favorite=" + favorite + ", id=" + id + ", launcher_id="
				+ launcher_id + ", launcher_name=" + launcher_name + ", time="
				+ time + ", title=" + title + "]";
	}

	private int favorite;
	private String cover_image;
	private String details_page;
	private String create_time;

	public Project(int id, String title, String time, int launcherId,
			int favorite, String coverImage, String detailsPage,
			String createTime) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
		launcher_id = launcherId;
		this.favorite = favorite;
		cover_image = coverImage;
		details_page = detailsPage;
		create_time = createTime;
	}

	public Project() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getLauncher_id() {
		return launcher_id;
	}

	public void setLauncher_id(int launcherId) {
		launcher_id = launcherId;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public String getCover_image() {
		return cover_image;
	}

	public void setCover_image(String coverImage) {
		cover_image = coverImage;
	}

	public String getDetails_page() {
		return details_page;
	}

	public void setDetails_page(String detailsPage) {
		details_page = detailsPage;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String createTime) {
		create_time = createTime;
	}

}
