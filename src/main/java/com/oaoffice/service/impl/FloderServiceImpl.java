package com.oaoffice.service.impl;

import java.util.List;


import com.oaoffice.bean.Floder;
import com.oaoffice.dao.FloderDao;
import com.oaoffice.dao.impl.FloderDaoImpl;
import com.oaoffice.service.FloderService;
import com.oaoffice.util.PagingVO;

public class FloderServiceImpl implements FloderService{
	private FloderDao floderdao=new FloderDaoImpl();
	
	
	public Integer insert(Floder bean) {
		// TODO Auto-generated method stub
		return floderdao.insert(bean);
	}

	
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return floderdao.delete(id);
	}

	
	public Integer update(Floder bean) {
		// TODO Auto-generated method stub
		return floderdao.update(bean);
	}

	
	public List<Floder> list() {
		// TODO Auto-generated method stub
		return floderdao.list();
	}

	
	public Floder load(Integer id) {
		// TODO Auto-generated method stub
		return floderdao.load(id);
	}

	
	public Integer count() {
		// TODO Auto-generated method stub
		return floderdao.count();
	}

	
	public Floder loadByName(String name) {
		// TODO Auto-generated method stub
		return floderdao.loadByName(name);
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return floderdao.countByName(name);
	}

	
	public Floder loadByNo(String no) {
		// TODO Auto-generated method stub
		return floderdao.loadByNo(no);
	}

	
	public List<Floder> listByName(String name) {
		// TODO Auto-generated method stub
		return floderdao.listByName(name);
	}

	
	public List<Floder> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return floderdao.queryAll(page);
	}

	
	public Floder getFloder(Floder stu) {
		// TODO Auto-generated method stub
		return floderdao.getFloder(stu);
	}

}
