package com.oaoffice.bean;

import java.util.Date;

public class Bulletin {
	private Integer bulletin_id;
	private String bulletin_title;
	private String bulletin_content;
	private java.util.Date bulletin_buildtime;
	private String user_realname;
	private Integer user_id;
	private Integer role_id;

	public Bulletin() {
		super();
	}
	
	

	public Bulletin( String bulletin_title, String bulletin_content, Date bulletin_buildtime,
			String user_realname, Integer user_id) {
		super();
		this.bulletin_title = bulletin_title;
		this.bulletin_content = bulletin_content;
		this.bulletin_buildtime = bulletin_buildtime;
		this.user_realname = user_realname;
		this.user_id = user_id;
	}



	public Bulletin(String bulletin_title, String bulletin_content, Date bulletin_buildtime, String user_realname,
			Integer user_id, Integer role_id) {
		super();
		this.bulletin_title = bulletin_title;
		this.bulletin_content = bulletin_content;
		this.bulletin_buildtime = bulletin_buildtime;
		this.user_realname = user_realname;
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public Bulletin(Integer bulletin_id, String bulletin_title, String bulletin_content, Date bulletin_buildtime,
			String user_realname, Integer user_id, Integer role_id) {
		super();
		this.bulletin_id = bulletin_id;
		this.bulletin_title = bulletin_title;
		this.bulletin_content = bulletin_content;
		this.bulletin_buildtime = bulletin_buildtime;
		this.user_realname = user_realname;
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public Integer getBulletin_id() {
		return bulletin_id;
	}

	public void setBulletin_id(Integer bulletin_id) {
		this.bulletin_id = bulletin_id;
	}

	public String getBulletin_title() {
		return bulletin_title;
	}

	public void setBulletin_title(String bulletin_title) {
		this.bulletin_title = bulletin_title;
	}

	public String getBulletin_content() {
		return bulletin_content;
	}

	public void setBulletin_content(String bulletin_content) {
		this.bulletin_content = bulletin_content;
	}

	public java.util.Date getBulletin_buildtime() {
		return bulletin_buildtime;
	}

	public void setBulletin_buildtime(java.util.Date bulletin_buildtime) {
		this.bulletin_buildtime = bulletin_buildtime;
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

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

}
