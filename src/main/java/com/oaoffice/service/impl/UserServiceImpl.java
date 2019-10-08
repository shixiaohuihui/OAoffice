package com.oaoffice.service.impl;

import java.util.List;

import com.oaoffice.bean.User;
import com.oaoffice.dao.UserDao;
import com.oaoffice.dao.impl.UserDaoImpl;
import com.oaoffice.service.UserService;
import com.oaoffice.util.PagingVO;

public class UserServiceImpl implements UserService{
	private UserDao userdao=new UserDaoImpl();
	
	
	public Integer insert(User bean) {
		// TODO Auto-generated method stub
		return userdao.insert(bean);
	}

	
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return userdao.delete(id);
	}

	
	public Integer update(User bean) {
		// TODO Auto-generated method stub
		return userdao.update(bean);
	}

	
	public List<User> list() {
		// TODO Auto-generated method stub
		return userdao.list();
	}

	
	public User load(Integer id) {
		// TODO Auto-generated method stub
		return userdao.load(id);
	}

	
	public Integer count() {
		// TODO Auto-generated method stub
		return userdao.count();
	}

	
	public User loadByName(String name) {
		// TODO Auto-generated method stub
		return userdao.loadByName(name);
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return userdao.countByName(name);
	}

	
	public User loadByNo(String no) {
		// TODO Auto-generated method stub
		return userdao.loadByNo(no);
	}

	
	public List<User> listByName(String name) {
		// TODO Auto-generated method stub
		return userdao.listByName(name);
	}

	
	public List<User> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return userdao.queryAll(page);
	}

	
	public User getUser(User stu) {
		// TODO Auto-generated method stub
		return userdao.getUser(stu);
	}

	
	public boolean checkUser(String uname) {
		User stu=new User();
		stu.setUser_name(uname);
		User s=userdao.getUser(stu);
		if(s!=null) {
			return true;
		}else {
			return false;
		}
		
	}
}


