package com.oaoffice.service.impl;

import java.util.List;


import com.oaoffice.bean.Bulletin;
import com.oaoffice.dao.BulletinDao;
import com.oaoffice.dao.impl.BulletinDaoImpl;
import com.oaoffice.service.BulletinService;
import com.oaoffice.util.PagingVO;

public class BulletinServiceImpl implements BulletinService{
	private BulletinDao bulletindao=new BulletinDaoImpl();
	
	
	public Integer insert(Bulletin bean) {
		// TODO Auto-generated method stub
		return bulletindao.insert(bean);
	}

	
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return bulletindao.delete(id);
	}

	
	public Integer update(Bulletin bean) {
		// TODO Auto-generated method stub
		return bulletindao.update(bean);
	}

	
	public List<Bulletin> list() {
		// TODO Auto-generated method stub
		return bulletindao.list();
	}

	
	public Bulletin load(Integer id) {
		// TODO Auto-generated method stub
		return bulletindao.load(id);
	}

	
	public Integer count() {
		// TODO Auto-generated method stub
		return bulletindao.count();
	}

	
	public Bulletin loadByName(String name) {
		// TODO Auto-generated method stub
		return bulletindao.loadByName(name);
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return bulletindao.countByName(name);
	}

	
	public Bulletin loadByNo(String no) {
		// TODO Auto-generated method stub
		return bulletindao.loadByNo(no);
	}

	
	public List<Bulletin> listByName(String name) {
		// TODO Auto-generated method stub
		return bulletindao.listByName(name);
	}

	
	public List<Bulletin> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return bulletindao.queryAll(page);
	}

	
	public Bulletin getBulletin(Bulletin stu) {
		// TODO Auto-generated method stub
		return bulletindao.getBulletin(stu);
	}

}
