package com.oaoffice.bean;

import java.util.Date;

public class Dothing {
	private Integer dothing_id;
	private String dothing_describe;
	private java.util.Date dothing_enddate;
	private String dothing_priority;
	private String dothing_result;
	private Integer user_id;

	//冗余字段
	private String user_realname;
	private String role_name;
	
	public Dothing() {
		super();
	}

	public Dothing(String dothing_describe, Date dothing_enddate, String dothing_priority, String dothing_result,
			Integer user_id) {
		super();
		this.dothing_describe = dothing_describe;
		this.dothing_enddate = dothing_enddate;
		this.dothing_priority = dothing_priority;
		this.dothing_result = dothing_result;
		this.user_id = user_id;
	}

	public Dothing(Integer dothing_id, String dothing_describe, Date dothing_enddate, String dothing_priority,
			String dothing_result, Integer user_id) {
		super();
		this.dothing_id = dothing_id;
		this.dothing_describe = dothing_describe;
		this.dothing_enddate = dothing_enddate;
		this.dothing_priority = dothing_priority;
		this.dothing_result = dothing_result;
		this.user_id = user_id;
	}

	public Integer getDothing_id() {
		return dothing_id;
	}

	public void setDothing_id(Integer dothing_id) {
		this.dothing_id = dothing_id;
	}

	public String getDothing_describe() {
		return dothing_describe;
	}

	public void setDothing_describe(String dothing_describe) {
		this.dothing_describe = dothing_describe;
	}

	public java.util.Date getDothing_enddate() {
		return dothing_enddate;
	}

	public void setDothing_enddate(java.util.Date dothing_enddate) {
		this.dothing_enddate = dothing_enddate;
	}

	public String getDothing_priority() {
		return dothing_priority;
	}

	public void setDothing_priority(String dothing_priority) {
		this.dothing_priority = dothing_priority;
	}

	public String getDothing_result() {
		return dothing_result;
	}

	public void setDothing_result(String dothing_result) {
		this.dothing_result = dothing_result;
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

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	

}
