package com.oaoffice.service.impl;

import java.util.List;


import com.oaoffice.bean.Meetingapply;
import com.oaoffice.dao.MeetingapplyDao;
import com.oaoffice.dao.impl.MeetingapplyDaoImpl;
import com.oaoffice.service.MeetingapplyService;
import com.oaoffice.util.PagingVO;

public class MeetingapplyServiceImpl implements MeetingapplyService{
	private MeetingapplyDao meetingapplydao=new MeetingapplyDaoImpl();
	
	
	public Integer insert(Meetingapply bean) {
		// TODO Auto-generated method stub
		return meetingapplydao.insert(bean);
	}

	
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return meetingapplydao.delete(id);
	}

	
	public Integer update(Meetingapply bean) {
		// TODO Auto-generated method stub
		return meetingapplydao.update(bean);
	}

	
	public List<Meetingapply> list() {
		// TODO Auto-generated method stub
		return meetingapplydao.list();
	}

	
	public Meetingapply load(Integer id) {
		// TODO Auto-generated method stub
		return meetingapplydao.load(id);
	}

	
	public Integer count() {
		// TODO Auto-generated method stub
		return meetingapplydao.count();
	}

	
	public Meetingapply loadByName(String name) {
		// TODO Auto-generated method stub
		return meetingapplydao.loadByName(name);
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return meetingapplydao.countByName(name);
	}

	
	public Meetingapply loadByNo(String no) {
		// TODO Auto-generated method stub
		return meetingapplydao.loadByNo(no);
	}

	
	public List<Meetingapply> listByName(String name) {
		// TODO Auto-generated method stub
		return meetingapplydao.listByName(name);
	}

	
	public List<Meetingapply> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return meetingapplydao.queryAll(page);
	}

	
	public Meetingapply getMeetingapply(Meetingapply stu) {
		// TODO Auto-generated method stub
		return meetingapplydao.getMeetingapply(stu);
	}

}
