package com.oaoffice.service.impl;

import java.util.List;

import com.oaoffice.bean.Power;
import com.oaoffice.bean.Power_Role;
import com.oaoffice.bean.Role;
import com.oaoffice.bean.User_Role;
import com.oaoffice.dao.*;
import com.oaoffice.dao.impl.*;
import com.oaoffice.service.*;

public class PowerServiceImpl implements PowerService {
    PowerDao powerDao=new PowerDaoImpl();

	public List<Power> list() {
		// TODO Auto-generated method stub
		return powerDao.list();
	}


	public User_Role loadByid(String id) {

		return powerDao.loadByid(id);
	}


	public List<Role> listByRole() {
		// TODO Auto-generated method stub
		return powerDao.listByRole();
	}


	public Integer updete(User_Role bean) {
		// TODO Auto-generated method stub
		return powerDao.updete(bean);
	}


	public List<Power_Role> listPower_Role(String id) {
		// TODO Auto-generated method stub
		return powerDao.listPower_Role(id);
	}


	public List<Power_Role> listPower() {
		// TODO Auto-generated method stub
		return powerDao.listPower();
	}


	public Integer delete(String role_id, String power_id) {
		// TODO Auto-generated method stub
		return powerDao.delete(role_id, power_id);
	}


	public boolean insert(String role_id, String power_id) {
		List<Power_Role> list = powerDao.listPower_Role(role_id);
		for (Power_Role key : list) {
			if (power_id.equals(key.getPower_id())) {
				return false;
			} else {
				powerDao.insert(role_id, power_id);
				return true;
			}
		}
		return false;
	}


	public List<Power> getPower(String uname) {
		// TODO Auto-generated method stub
		return powerDao.getPower(uname);
	}


	public List<Power> list1() {
		// TODO Auto-generated method stub
		return powerDao.list1();
	}
	

	public List<Power> search(String str) {
		// TODO Auto-generated method stub
		return powerDao.search(str);
	}

}
