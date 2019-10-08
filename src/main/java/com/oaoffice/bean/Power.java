package com.oaoffice.bean;

public class Power {
	private int power_id;
	private String power_url;
	private int power_ismenu;
	private int power_pid;
	private String key;
	private String user_id;
	private String user_realname;
	private String role_name;
	private String power_name;

	// 冗余字段
	private String user_name;
	private int role_id;

	public Power() {
		super();
	}

	public Power(int power_id, String power_name, String power_url, int power_ismenu, int power_pid, String key) {
		super();
		this.power_id = power_id;
		this.power_name = power_name;
		this.power_url = power_url;
		this.power_ismenu = power_ismenu;
		this.power_pid = power_pid;
		this.key = key;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getPower_id() {
		return power_id;
	}

	public void setPower_id(int power_id) {
		this.power_id = power_id;
	}

	public String getPower_url() {
		return power_url;
	}

	public void setPower_url(String power_url) {
		this.power_url = power_url;
	}

	

	public int getPower_ismenu() {
		return power_ismenu;
	}

	public void setPower_ismenu(int power_ismenu) {
		this.power_ismenu = power_ismenu;
	}

	public int getPower_pid() {
		return power_pid;
	}

	public void setPower_pid(int power_pid) {
		this.power_pid = power_pid;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
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

	public String getPower_name() {
		return power_name;
	}

	public void setPower_name(String power_name) {
		this.power_name = power_name;
	}
}
