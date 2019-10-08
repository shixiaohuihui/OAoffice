package com.oaoffice.bean;

public class Dept {
	private String dept_id;
	private String dept_name;
	private String dept_description;
	public Dept() {}
	
	public Dept(String dept_name, String dept_description) {
		this.dept_name = dept_name;
		this.dept_description = dept_description;
	}

	public Dept(String dept_id, String dept_name, String dept_description) {
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_description = dept_description;
	}

	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_description() {
		return dept_description;
	}
	public void setDept_description(String dept_description) {
		this.dept_description = dept_description;
	}
	
	}
