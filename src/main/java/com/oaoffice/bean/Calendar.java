package com.oaoffice.bean;

import java.util.Date;

public class Calendar {
	private Integer calendar_id;
	private String calendar_title;
	private java.util.Date calendar_starttime;
	private java.util.Date calendar_endtime;
	private String calendar_remind;
	private String calendar_content;
	private Integer user_id;

	public Calendar() {
		super();
	}

	public Calendar(String calendar_title, Date calendar_starttime, Date calendar_endtime, String calendar_remind,
			String calendar_content, Integer user_id) {
		super();
		this.calendar_title = calendar_title;
		this.calendar_starttime = calendar_starttime;
		this.calendar_endtime = calendar_endtime;
		this.calendar_remind = calendar_remind;
		this.calendar_content = calendar_content;
		this.user_id = user_id;
	}

	public Calendar(Integer calendar_id, String calendar_title, Date calendar_starttime, Date calendar_endtime,
			String calendar_remind, String calendar_content, Integer user_id) {
		super();
		this.calendar_id = calendar_id;
		this.calendar_title = calendar_title;
		this.calendar_starttime = calendar_starttime;
		this.calendar_endtime = calendar_endtime;
		this.calendar_remind = calendar_remind;
		this.calendar_content = calendar_content;
		this.user_id = user_id;
	}

	public Integer getCalendar_id() {
		return calendar_id;
	}

	public void setCalendar_id(Integer calendar_id) {
		this.calendar_id = calendar_id;
	}

	public String getCalendar_title() {
		return calendar_title;
	}

	public void setCalendar_title(String calendar_title) {
		this.calendar_title = calendar_title;
	}

	public java.util.Date getCalendar_starttime() {
		return calendar_starttime;
	}

	public void setCalendar_starttime(java.util.Date calendar_starttime) {
		this.calendar_starttime = calendar_starttime;
	}

	public java.util.Date getCalendar_endtime() {
		return calendar_endtime;
	}

	public void setCalendar_endtime(java.util.Date calendar_endtime) {
		this.calendar_endtime = calendar_endtime;
	}

	public String getCalendar_remind() {
		return calendar_remind;
	}

	public void setCalendar_remind(String calendar_remind) {
		this.calendar_remind = calendar_remind;
	}

	public String getCalendar_content() {
		return calendar_content;
	}

	public void setCalendar_content(String calendar_content) {
		this.calendar_content = calendar_content;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

}
