package com.oaoffice.service.impl;

import java.util.List;

import com.oaoffice.bean.MeetingRoom;
import com.oaoffice.dao.MeetingRoomDao;
import com.oaoffice.dao.impl.MeetingRoomDaoImpl;
import com.oaoffice.service.MeetingRoomService;
import com.oaoffice.util.PagingVO;

public class MeetingRoomServiceImpl implements MeetingRoomService {
	private MeetingRoomDao Meetingdao = new MeetingRoomDaoImpl();

	
	public Integer insert(MeetingRoom bean) {
		// TODO Auto-generated method stub
		return Meetingdao.insert(bean);
	}

	
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return Meetingdao.delete(id);
	}

	
	public Integer update(MeetingRoom bean) {
		// TODO Auto-generated method stub
		return Meetingdao.update(bean);
	}

	
	public List<MeetingRoom> list() {
		// TODO Auto-generated method stub
		return Meetingdao.list();
	}

	
	public MeetingRoom load(Integer id) {
		// TODO Auto-generated method stub
		return Meetingdao.load(id);
	}

	
	public Integer count() {
		// TODO Auto-generated method stub
		return Meetingdao.count();
	}

	
	public MeetingRoom loadByName(String name) {
		// TODO Auto-generated method stub
		return Meetingdao.loadByName(name);
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return Meetingdao.countByName(name);
	}

	
	public MeetingRoom loadByNo(String no) {
		// TODO Auto-generated method stub
		return Meetingdao.loadByNo(no);
	}

	
	public List<MeetingRoom> listByName(String name) {
		// TODO Auto-generated method stub
		return Meetingdao.listByName(name);
	}

	
	public List<MeetingRoom> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return Meetingdao.queryAll(page);
	}

	
	public MeetingRoom getMeetingRoom(MeetingRoom stu) {
		// TODO Auto-generated method stub
		return Meetingdao.getMeetingRoom(stu);
	}

}
