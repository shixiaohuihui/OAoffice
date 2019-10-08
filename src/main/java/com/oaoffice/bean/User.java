package com.oaoffice.bean;

import java.util.Date;

public class User {
	private Integer user_id;
	private String user_name;
	private String user_realname;
	private String user_pwd;
	private String user_sex;
	private String phonenumber;
	private java.util.Date user_born;
	private String user_address;
	private String user_hobby;
	private String user_email;
	private String selfassessment;
	private String headpic;
	private Integer dept_id;

	// 冗余字段
	private Integer role_id;
	private String dept_name;
	private String role_name;

	public User(String user_pwd) {
		super();
		this.user_pwd = user_pwd;
	}
    
	
	
	public User(String user_name, String user_realname, String user_pwd, String user_sex, String phonenumber,
			Date user_born, String user_address, String user_hobby, String user_email, String selfassessment,
			String headpic, Integer dept_id) {
		super();
		this.user_name = user_name;
		this.user_realname = user_realname;
		this.user_pwd = user_pwd;
		this.user_sex = user_sex;
		this.phonenumber = phonenumber;
		this.user_born = user_born;
		this.user_address = user_address;
		this.user_hobby = user_hobby;
		this.user_email = user_email;
		this.selfassessment = selfassessment;
		this.headpic = headpic;
		this.dept_id = dept_id;
	}



	public User(String user_name, String user_realname, String user_pwd, String user_sex, String phonenumber,
			Date user_born, String user_address, String user_hobby, String user_email, String headpic,
			Integer dept_id) {
		super();
		this.user_name = user_name;
		this.user_realname = user_realname;
		this.user_pwd = user_pwd;
		this.user_sex = user_sex;
		this.phonenumber = phonenumber;
		this.user_born = user_born;
		this.user_address = user_address;
		this.user_hobby = user_hobby;
		this.user_email = user_email;
		this.headpic = headpic;
		this.dept_id = dept_id;
	}

	public User(String user_name, String user_realname, String user_sex, String phonenumber, Date user_born,
			String user_address, String user_hobby, String user_email, String selfassessment, String headpic) {
		super();
		this.user_name = user_name;
		this.user_realname = user_realname;
		this.user_sex = user_sex;
		this.phonenumber = phonenumber;
		this.user_born = user_born;
		this.user_address = user_address;
		this.user_hobby = user_hobby;
		this.user_email = user_email;
		this.selfassessment = selfassessment;
		this.headpic = headpic;
	}

	public User(String user_name, String user_realname, String user_pwd, String user_sex, String phonenumber,
			Date user_born, String user_address, String user_email, String headpic, Integer dept_id) {
		super();
		this.user_name = user_name;
		this.user_realname = user_realname;
		this.user_pwd = user_pwd;
		this.user_sex = user_sex;
		this.phonenumber = phonenumber;
		this.user_born = user_born;
		this.user_address = user_address;
		this.user_email = user_email;
		this.headpic = headpic;
		this.dept_id = dept_id;
	}

	public User(Integer user_id, String user_name, String user_realname, String user_pwd, String user_sex,
			String phonenumber, Date user_born, String user_address, String user_email, String headpic) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_realname = user_realname;
		this.user_pwd = user_pwd;
		this.user_sex = user_sex;
		this.phonenumber = phonenumber;
		this.user_born = user_born;
		this.user_address = user_address;
		this.user_email = user_email;
		this.headpic = headpic;
	}

	public User(Integer user_id, String user_name, String user_realname, String user_pwd, String user_sex,
			String phonenumber, Date user_born, String user_address, String user_hobby, String user_email,
			String selfassessment, String headpic, Integer dept_id) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_realname = user_realname;
		this.user_pwd = user_pwd;
		this.user_sex = user_sex;
		this.phonenumber = phonenumber;
		this.user_born = user_born;
		this.user_address = user_address;
		this.user_hobby = user_hobby;
		this.user_email = user_email;
		this.selfassessment = selfassessment;
		this.headpic = headpic;
		this.dept_id = dept_id;
	}

	public User() {
		super();
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_realname() {
		return user_realname;
	}

	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public java.util.Date getUser_born() {
		return user_born;
	}

	public void setUser_born(java.util.Date user_born) {
		this.user_born = user_born;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_hobby() {
		return user_hobby;
	}

	public void setUser_hobby(String user_hobby) {
		this.user_hobby = user_hobby;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getSelfassessment() {
		return selfassessment;
	}

	public void setSelfassessment(String selfassessment) {
		this.selfassessment = selfassessment;
	}

	public String getHeadpic() {
		return headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	

}
