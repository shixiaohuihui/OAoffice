package com.oaoffice.bean;

import java.util.Date;

public class Vacate {
	private Integer vacate_id;
	private java.util.Date vacate_sharttime;
	private String vacate_time;
	private String vacate_reason;
	private Integer user_id;
	private String approver;
	private String vacate_state;
	private Integer role_id;

	//冗余字段
	private String user_realname;
	
	public Vacate() {
		super();
	}

	
	
	public Vacate(Date vacate_sharttime, String vacate_time, String vacate_reason, String approver,
			String vacate_state) {
		super();
		this.vacate_sharttime = vacate_sharttime;
		this.vacate_time = vacate_time;
		this.vacate_reason = vacate_reason;
		this.approver = approver;
		this.vacate_state = vacate_state;
	}



	public Vacate(Date vacate_sharttime, String vacate_time, String vacate_reason, String user_realname) {
		super();
		this.vacate_sharttime = vacate_sharttime;
		this.vacate_time = vacate_time;
		this.vacate_reason = vacate_reason;
		this.user_realname = user_realname;
	}



	public Vacate(Date vacate_sharttime, String vacate_time, String vacate_reason, Integer user_id, String approver,
			String vacate_state) {
		super();
		this.vacate_sharttime = vacate_sharttime;
		this.vacate_time = vacate_time;
		this.vacate_reason = vacate_reason;
		this.user_id = user_id;
		this.approver = approver;
		this.vacate_state = vacate_state;
	}


	public Vacate(Date vacate_sharttime, String vacate_time, String vacate_reason, Integer user_id) {
		super();
		this.vacate_sharttime = vacate_sharttime;
		this.vacate_time = vacate_time;
		this.vacate_reason = vacate_reason;
		this.user_id = user_id;
	}


	public Vacate(Date vacate_sharttime, String vacate_time, String vacate_reason, Integer user_id, String approver,
			String vacate_state, Integer role_id) {
		super();
		this.vacate_sharttime = vacate_sharttime;
		this.vacate_time = vacate_time;
		this.vacate_reason = vacate_reason;
		this.user_id = user_id;
		this.approver = approver;
		this.vacate_state = vacate_state;
		this.role_id = role_id;
	}

	public Vacate(Integer vacate_id, Date vacate_sharttime, String vacate_time, String vacate_reason, Integer user_id,
			String approver, String vacate_state, Integer role_id) {
		super();
		this.vacate_id = vacate_id;
		this.vacate_sharttime = vacate_sharttime;
		this.vacate_time = vacate_time;
		this.vacate_reason = vacate_reason;
		this.user_id = user_id;
		this.approver = approver;
		this.vacate_state = vacate_state;
		this.role_id = role_id;
	}

	public Integer getVacate_id() {
		return vacate_id;
	}

	public void setVacate_id(Integer vacate_id) {
		this.vacate_id = vacate_id;
	}

	public java.util.Date getVacate_sharttime() {
		return vacate_sharttime;
	}

	public void setVacate_sharttime(java.util.Date vacate_sharttime) {
		this.vacate_sharttime = vacate_sharttime;
	}

	public String getVacate_time() {
		return vacate_time;
	}

	public void setVacate_time(String vacate_time) {
		this.vacate_time = vacate_time;
	}

	public String getVacate_reason() {
		return vacate_reason;
	}

	public void setVacate_reason(String vacate_reason) {
		this.vacate_reason = vacate_reason;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getVacate_state() {
		return vacate_state;
	}

	public void setVacate_state(String vacate_state) {
		this.vacate_state = vacate_state;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}


	public String getUser_realname() {
		return user_realname;
	}


	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}


}
