package com.oaoffice.bean;

public class Floder {
	private Integer floder_id;
	private String floder_name;
	private String floder_content;
	private String floder_path;
	private Integer floder_isshare;
	private Integer user_id;
	
	//冗余字段
	private String user_realname;

	public Floder() {
		super();
	}

	public Floder(String floder_name, String floder_content, String floder_path, Integer floder_isshare,
			Integer user_id) {
		super();
		this.floder_name = floder_name;
		this.floder_content = floder_content;
		this.floder_path = floder_path;
		this.floder_isshare = floder_isshare;
		this.user_id = user_id;
	}

	public Floder(Integer floder_id, String floder_name, String floder_content, String floder_path,
			Integer floder_isshare, Integer user_id) {
		super();
		this.floder_id = floder_id;
		this.floder_name = floder_name;
		this.floder_content = floder_content;
		this.floder_path = floder_path;
		this.floder_isshare = floder_isshare;
		this.user_id = user_id;
	}

	public Integer getFloder_id() {
		return floder_id;
	}

	public void setFloder_id(Integer floder_id) {
		this.floder_id = floder_id;
	}

	public String getFloder_name() {
		return floder_name;
	}

	public void setFloder_name(String floder_name) {
		this.floder_name = floder_name;
	}

	public String getFloder_content() {
		return floder_content;
	}

	public void setFloder_content(String floder_content) {
		this.floder_content = floder_content;
	}

	public String getFloder_path() {
		return floder_path;
	}

	public void setFloder_path(String floder_path) {
		this.floder_path = floder_path;
	}

	public Integer getFloder_isshare() {
		return floder_isshare;
	}

	public void setFloder_isshare(Integer floder_isshare) {
		this.floder_isshare = floder_isshare;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_realname() {
		return user_realname;
	}

	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}
	
	

}
