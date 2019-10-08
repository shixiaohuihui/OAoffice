package com.oaoffice.bean;

public class MeetingRoom {
	private int meetingroom_id;
	private String meetingroom_name;
	private String usercount;

	public MeetingRoom() {
	}

	public MeetingRoom(String meetingroom_name, String usercount) {
		this.meetingroom_name = meetingroom_name;
		this.usercount = usercount;
	}

	public MeetingRoom(int meetingroom_id, String meetingroom_name, String usercount) {
		super();
		this.meetingroom_id = meetingroom_id;
		this.meetingroom_name = meetingroom_name;
		this.usercount = usercount;
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

	public String getUsercount() {
		return usercount;
	}

	public void setUsercount(String usercount) {
		this.usercount = usercount;
	}

}
