package com.oaoffice.service;

import java.util.List;

import com.oaoffice.bean.Power;
import com.oaoffice.bean.Power_Role;
import com.oaoffice.bean.Role;
import com.oaoffice.bean.User_Role;

public interface PowerService {
	// 根据用户获取权限
	public List<Power> getPower(String uname);

	List<Power> list();// 返回所有行的数据
	
	List<Power> list1();// 返回所有行的数据

	User_Role loadByid(String id);// 用id查询

	List<Role> listByRole();//

	Integer updete(User_Role bean);// 修改职位

	List<Power_Role> listPower_Role(String id);

	List<Power_Role> listPower();

	Integer delete(String role_id, String power_id);
	
	boolean insert(String role_id, String power_id);
	
	List<Power> search(String str);
	
	
}
