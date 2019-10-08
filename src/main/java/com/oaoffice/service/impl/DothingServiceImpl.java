package com.oaoffice.service.impl;

import java.util.List;


import com.oaoffice.bean.Dothing;
import com.oaoffice.dao.DothingDao;
import com.oaoffice.dao.impl.DothingDaoImpl;
import com.oaoffice.service.DothingService;
import com.oaoffice.util.PagingVO;

public class DothingServiceImpl implements DothingService{
	private DothingDao dothingdao=new DothingDaoImpl();
	
	
	public Integer insert(Dothing bean) {
		// TODO Auto-generated method stub
		return dothingdao.insert(bean);
	}

	
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return dothingdao.delete(id);
	}

	
	public Integer update(Dothing bean) {
		// TODO Auto-generated method stub
		return dothingdao.update(bean);
	}

	
	public List<Dothing> list() {
		// TODO Auto-generated method stub
		return dothingdao.list();
	}

	
	public Dothing load(Integer id) {
		// TODO Auto-generated method stub
		return dothingdao.load(id);
	}

	
	public Integer count() {
		// TODO Auto-generated method stub
		return dothingdao.count();
	}

	
	public Dothing loadByName(String name) {
		// TODO Auto-generated method stub
		return dothingdao.loadByName(name);
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return dothingdao.countByName(name);
	}

	
	public Dothing loadByNo(String no) {
		// TODO Auto-generated method stub
		return dothingdao.loadByNo(no);
	}

	
	public List<Dothing> listByName(String name) {
		// TODO Auto-generated method stub
		return dothingdao.listByName(name);
	}

	
	public List<Dothing> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return dothingdao.queryAll(page);
	}

	
	public Dothing getDothing(Dothing stu) {
		// TODO Auto-generated method stub
		return dothingdao.getDothing(stu);
	}

}
