package com.oaoffice.bean;

import java.util.Date;

public class Meetingapply {
	private Integer meetingapply_id;
	private java.util.Date meetingapply_time;
	private String meetingapply_reason;
	private Integer user_id;
	private String approver;
	private String meetingapply_state;
	private Integer role_id;
	private String twoapprover;
	private String twomeetingapply_state;
	
	//冗余字段
	private String user_realname;

	public Meetingapply() {
		super();
	}
	
	
    
	public Meetingapply(Date meetingapply_time, String meetingapply_reason, Integer user_id, String approver,
			String meetingapply_state, String twoapprover, String twomeetingapply_state) {
		super();
		this.meetingapply_time = meetingapply_time;
		this.meetingapply_reason = meetingapply_reason;
		this.user_id = user_id;
		this.approver = approver;
		this.meetingapply_state = meetingapply_state;
		this.twoapprover = twoapprover;
		this.twomeetingapply_state = twomeetingapply_state;
	}



	public Meetingapply(Date meetingapply_time, String meetingapply_reason, Integer user_id) {
		super();
		this.meetingapply_time = meetingapply_time;
		this.meetingapply_reason = meetingapply_reason;
		this.user_id = user_id;
	}

	public Meetingapply(Date meetingapply_time, String meetingapply_reason, Integer user_id, String approver,
			String meetingapply_state) {
		super();
		this.meetingapply_time = meetingapply_time;
		this.meetingapply_reason = meetingapply_reason;
		this.user_id = user_id;
		this.approver = approver;
		this.meetingapply_state = meetingapply_state;
	}

	public Meetingapply(Integer meetingapply_id, Date meetingapply_time, String meetingapply_reason, Integer user_id,
			String approver, String meetingapply_state, Integer role_id) {
		super();
		this.meetingapply_id = meetingapply_id;
		this.meetingapply_time = meetingapply_time;
		this.meetingapply_reason = meetingapply_reason;
		this.user_id = user_id;
		this.approver = approver;
		this.meetingapply_state = meetingapply_state;
		this.role_id = role_id;
	}

	public Integer getMeetingapply_id() {
		return meetingapply_id;
	}

	public void setMeetingapply_id(Integer meetingapply_id) {
		this.meetingapply_id = meetingapply_id;
	}

	public java.util.Date getMeetingapply_time() {
		return meetingapply_time;
	}

	public void setMeetingapply_time(java.util.Date meetingapply_time) {
		this.meetingapply_time = meetingapply_time;
	}

	public String getMeetingapply_reason() {
		return meetingapply_reason;
	}

	public void setMeetingapply_reason(String meetingapply_reason) {
		this.meetingapply_reason = meetingapply_reason;
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

	public String getMeetingapply_state() {
		return meetingapply_state;
	}

	public void setMeetingapply_state(String meetingapply_state) {
		this.meetingapply_state = meetingapply_state;
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

	public String getTwoapprover() {
		return twoapprover;
	}

	public void setTwoapprover(String twoapprover) {
		this.twoapprover = twoapprover;
	}

	public String getTwomeetingapply_state() {
		return twomeetingapply_state;
	}

	public void setTwomeetingapply_state(String twomeetingapply_state) {
		this.twomeetingapply_state = twomeetingapply_state;
	}
    
	
}
