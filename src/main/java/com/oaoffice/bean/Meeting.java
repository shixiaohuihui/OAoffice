package com.oaoffice.bean;

import java.util.Date;

public class Meeting {
	private int meeting_id;
	private String meeting_title;
	private java.util.Date meeting_date;
	private java.util.Date meeting_start;
	private java.util.Date meeting_end;
	private String meeting_status;
	private int meetingroom_id;
	private String meetingroom_name;

	public Meeting() {
	}

	public Meeting(String meeting_title, Date meeting_date, Date meeting_start, Date meeting_end,
			String meeting_statuss, int meetingroom_id) {
		this.meeting_title = meeting_title;
		this.meeting_date = meeting_date;
		this.meeting_start = meeting_start;
		this.meeting_end = meeting_end;
		this.meeting_status = meeting_statuss;
		this.meetingroom_id = meetingroom_id;
	}

	public Meeting(int meeting_id, String meeting_title, Date meeting_date, Date meeting_start, Date meeting_end,
			String meeting_statuss, int meetingroom_id, String meetingroom_name) {
		super();
		this.meeting_id = meeting_id;
		this.meeting_title = meeting_title;
		this.meeting_date = meeting_date;
		this.meeting_start = meeting_start;
		this.meeting_end = meeting_end;
		this.meeting_status = meeting_statuss;
		this.meetingroom_id = meetingroom_id;
		this.meetingroom_name = meetingroom_name;
	}

	public int getMeeting_id() {
		return meeting_id;
	}

	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}

	public String getMeeting_title() {
		return meeting_title;
	}

	public void setMeeting_title(String meeting_title) {
		this.meeting_title = meeting_title;
	}

	public java.util.Date getMeeting_date() {
		return meeting_date;
	}

	public void setMeeting_date(java.util.Date meeting_date) {
		this.meeting_date = meeting_date;
	}

	public java.util.Date getMeeting_start() {
		return meeting_start;
	}

	public void setMeeting_start(java.util.Date meeting_start) {
		this.meeting_start = meeting_start;
	}

	public java.util.Date getMeeting_end() {
		return meeting_end;
	}

	public void setMeeting_end(java.util.Date meeting_end) {
		this.meeting_end = meeting_end;
	}

	public String getMeeting_status() {
		return meeting_status;
	}

	public void setMeeting_status(String meeting_status) {
		this.meeting_status = meeting_status;
	}

	public int getMeetingroom_id() {
		return meetingroom_id;
	}

	public void setMeetingroom_id(int meetingroom_id) {
		this.meetingroom_id = meetingroom_id;
	}

	public String getMeetingroom_name() {
		return meetingroom_name;
	}

	public void setMeetingroom_name(String meetingroom_name) {
		this.meetingroom_name = meetingroom_name;
	}

}
