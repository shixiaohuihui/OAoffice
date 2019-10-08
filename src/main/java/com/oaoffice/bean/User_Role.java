package com.oaoffice.bean;

public class User_Role {
	private String user_realname;
	private String user_id;
	private String role_id;
	private String role_name;
	public User_Role() {}
	public User_Role(String user_id, String role_id) {
		this.user_id = user_id;
		this.role_id = role_id;
	}
	
	public String getUser_realname() {
		return user_realname;
	}
	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
}
