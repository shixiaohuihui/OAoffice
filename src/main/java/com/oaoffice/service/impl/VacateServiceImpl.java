package com.oaoffice.service.impl;

import java.util.List;


import com.oaoffice.bean.Vacate;
import com.oaoffice.dao.VacateDao;
import com.oaoffice.dao.impl.VacateDaoImpl;
import com.oaoffice.service.VacateService;
import com.oaoffice.util.PagingVO;

public class VacateServiceImpl implements VacateService{
	private VacateDao vacatedao=new VacateDaoImpl();
	
	
	public Integer insert(Vacate bean) {
		// TODO Auto-generated method stub
		return vacatedao.insert(bean);
	}

	
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return vacatedao.delete(id);
	}

	
	public Integer update(Vacate bean) {
		// TODO Auto-generated method stub
		return vacatedao.update(bean);
	}

	
	public List<Vacate> list() {
		// TODO Auto-generated method stub
		return vacatedao.list();
	}

	
	public Vacate load(Integer id) {
		// TODO Auto-generated method stub
		return vacatedao.load(id);
	}

	
	public Integer count() {
		// TODO Auto-generated method stub
		return vacatedao.count();
	}

	
	public Vacate loadByName(String name) {
		// TODO Auto-generated method stub
		return vacatedao.loadByName(name);
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return vacatedao.countByName(name);
	}

	
	public Vacate loadByNo(String no) {
		// TODO Auto-generated method stub
		return vacatedao.loadByNo(no);
	}

	
	public List<Vacate> listByName(String name) {
		// TODO Auto-generated method stub
		return vacatedao.listByName(name);
	}

	
	public List<Vacate> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return vacatedao.queryAll(page);
	}

	
	public Vacate getVacate(Vacate stu) {
		// TODO Auto-generated method stub
		return vacatedao.getVacate(stu);
	}

}
