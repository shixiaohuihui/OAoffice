package com.oaoffice.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.oaoffice.util.DbFun;
import com.oaoffice.bean.User;
import com.oaoffice.dao.UserDao;
import com.oaoffice.util.PagingVO;

public class UserDaoImpl implements UserDao{


	@SuppressWarnings("resource")
	
	public Integer insert(User bean) {
		//user_id,user_name,user_realname,user_pwd,user_sex,phonenumber,user_born
		//user_address,user_hobby,user_email,selfassessment,headpic,dept_id
		StringBuilder sb = new StringBuilder();
		sb.append(" Insert Into User(user_name,user_realname,user_pwd,user_sex,");
		sb.append(" phonenumber,user_born,user_address,user_email,headpic,dept_id)");
		sb.append("Values(?,?,?,?,?,?,?,?,?,?)");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
       
		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getUser_name());
			pstmt.setObject(2, bean.getUser_realname());
			pstmt.setObject(3, bean.getUser_pwd());
			pstmt.setObject(4, bean.getUser_sex());
			pstmt.setObject(5, bean.getPhonenumber());
			pstmt.setObject(6, bean.getUser_born());
			pstmt.setObject(7, bean.getUser_address());
			pstmt.setObject(8, bean.getUser_email());
			pstmt.setObject(9, bean.getHeadpic());
			pstmt.setObject(10, bean.getDept_id());

			num = pstmt.executeUpdate();

			// 如果受影响行数大于0，说明添加成功；之后，要获取刚刚添加的行的主键值
			if (num > 0) {
				sql = "Select @@Identity";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					num = rs.getInt(1);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return num;
	}
	
	
	public List<User> list() {
		List<User> list = new ArrayList<User>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT"); 
		sb.append("	a.*,");
		sb.append("	d.role_name,");
		sb.append(" b.dept_name");
		sb.append(" FROM" ); 
		sb.append("	USER AS a");
		sb.append("	LEFT JOIN dept b ON a.dept_id = b.dept_id ");
		sb.append("	LEFT JOIN user_role c ON c.user_id = a.user_id ");
		sb.append("	LEFT JOIN role d ON c.role_id = d.role_id ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//user_id,user_name,user_realname,user_pwd,user_sex,phonenumber,user_born
		//user_address,user_hobby,user_email,selfassessment,headpic,dept_id
		
		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			User tmpbean = null;
			while (rs.next()) {
				tmpbean = new User();
				tmpbean.setUser_id(rs.getInt("user_id"));
				tmpbean.setUser_name(rs.getString("user_name"));
				tmpbean.setUser_realname(rs.getString("user_realname"));
				tmpbean.setUser_pwd(rs.getString("user_pwd"));
				tmpbean.setUser_sex(rs.getString("user_sex"));
				tmpbean.setPhonenumber(rs.getString("phonenumber"));
				tmpbean.setUser_born(rs.getDate("user_born"));
				tmpbean.setUser_address(rs.getString("user_address"));
				tmpbean.setUser_email(rs.getString("user_email"));
				tmpbean.setHeadpic(rs.getString("headpic"));
				tmpbean.setDept_id(rs.getInt("dept_id"));
				tmpbean.setDept_name(rs.getString("dept_name"));
				tmpbean.setRole_name(rs.getString("role_name"));
				
				list.add(tmpbean);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return list;
	}

	
	public Integer delete(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" delete from User where user_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);

			num = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return num;
	}

	
	public Integer update(User bean) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" update User Set ");
		sb.append(" user_name=? ");
		sb.append(" ,user_realname=? ");
		sb.append(" ,user_pwd=? ");
		sb.append(" ,user_sex=? ");
		sb.append(" ,phonenumber=? ");
		sb.append(" ,user_born=? ");
		sb.append(" ,user_address=? ");
		sb.append(" ,user_hobby=? ");
		sb.append(" ,user_email=? ");
		sb.append(" ,selfassessment=? ");
		sb.append(" ,headpic=? ");
		sb.append(" ,dept_id=? ");
		sb.append(" where user_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;
		//uname,upass,realName,gender,birthday	
		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getUser_name());
			pstmt.setObject(2, bean.getUser_realname());
			pstmt.setObject(3, bean.getUser_pwd());
			pstmt.setObject(4, bean.getUser_sex());
			pstmt.setObject(5, bean.getPhonenumber());
			pstmt.setObject(6, bean.getUser_born());
			pstmt.setObject(7, bean.getUser_address());
			pstmt.setObject(8, bean.getUser_hobby());
			pstmt.setObject(9, bean.getUser_email());
			pstmt.setObject(10, bean.getSelfassessment());
			pstmt.setObject(11, bean.getHeadpic());
			pstmt.setObject(12, bean.getDept_id());
			pstmt.setObject(13, bean.getUser_id());

			num = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return num;
	}

	
	public User load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT"); 
		sb.append("	a.*,");
		sb.append(" b.dept_name");
		sb.append(" FROM" ); 
		sb.append("	USER AS a");
		sb.append("	LEFT JOIN dept b ON a.dept_id = b.dept_id ");
		sb.append(" Where user_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new User();
				bean.setUser_id(rs.getInt("user_id"));
				bean.setUser_name(rs.getString("user_name"));
				bean.setUser_realname(rs.getString("user_realname"));
				bean.setUser_pwd(rs.getString("user_pwd"));
				bean.setUser_sex(rs.getString("user_sex"));
				bean.setPhonenumber(rs.getString("phonenumber"));
			    bean.setUser_born(rs.getDate("user_born"));
				bean.setUser_address(rs.getString("user_address"));
				bean.setUser_hobby(rs.getString("user_hobby"));
				bean.setUser_email(rs.getString("user_email"));
				bean.setSelfassessment(rs.getString("selfassessment"));
				bean.setHeadpic(rs.getString("headpic"));
				bean.setDept_id(rs.getInt("dept_id"));
				bean.setDept_name(rs.getString("dept_name"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return bean;
	}

	
	public Integer count() {
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(1) from User");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				num=rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return num;
	}

	
	public User loadByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public User loadByNo(String no) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from User");
		sb.append(" Where user_name=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new User();
	
				bean.setUser_id(rs.getInt("user_id"));
				bean.setUser_name(rs.getString("user_name"));
				bean.setUser_realname(rs.getString("user_realname"));
				bean.setUser_pwd(rs.getString("user_pwd"));
				bean.setUser_sex(rs.getString("user_sex"));
				bean.setPhonenumber(rs.getString("phonenumber"));
			    bean.setUser_born(rs.getDate("user_born"));
				bean.setUser_address(rs.getString("user_address"));
				bean.setUser_hobby(rs.getString("user_hobby"));
				bean.setUser_email(rs.getString("user_email"));
				bean.setSelfassessment(rs.getString("selfassessment"));
				bean.setHeadpic(rs.getString("headpic"));
				bean.setDept_id(rs.getInt("dept_id"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return bean;
	}

	
	public List<User> listByName(String name) {
		List<User> list = new ArrayList<User>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT"); 
		sb.append("	a.*,");
		sb.append(" b.dept_name");
		sb.append(" FROM" ); 
		sb.append("	USER AS a");
		sb.append("	LEFT JOIN dept b ON a.dept_id = b.dept_id ");
		sb.append(" where user_name like ? or user_realname like ?");
		String sql = sb.toString();
		
		name ="%" + name + "%";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, name);
			pstmt.setObject(2, name);
			
			rs = pstmt.executeQuery();

			User tmpbean = null;
			while (rs.next()) {
				tmpbean =new User();
				show(tmpbean, rs);
				
				list.add(tmpbean);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return list;
	}

	
	public List<User> queryAll(PagingVO page) {
		int begin=(page.getCurentPageNo()-1)*page.getPageSize();
		int end=page.getPageSize();
		List<User> list = new ArrayList<User>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT"); 
		sb.append("	a.*,");
		sb.append(" b.dept_name");
		sb.append(" FROM" ); 
		sb.append("	USER AS a");
		sb.append("	LEFT JOIN dept b ON a.dept_id = b.dept_id ");
		sb.append(" ORDER BY a.user_id ");
		sb.append(" limit ?,?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

	
		
		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			User tmpbean = null;
			
			while (rs.next()) {
				tmpbean = new User();
				show(tmpbean, rs);
				list.add(tmpbean);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return list;
	}

	
	public User getUser(User stu) {
		User tmpbean = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from User");
		sb.append(" where user_name=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, stu.getUser_name());
			
			rs = pstmt.executeQuery();

			
			if (rs.next()) {
				tmpbean =new User();
				show(tmpbean, rs);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return tmpbean;
	}

	
	
	private void show(User tmpbean, ResultSet rs) throws SQLException {
		tmpbean.setUser_id(rs.getInt("user_id"));
		tmpbean.setUser_name(rs.getString("user_name"));
		tmpbean.setUser_realname(rs.getString("user_realname"));
		tmpbean.setUser_pwd(rs.getString("user_pwd"));
		tmpbean.setUser_sex(rs.getString("user_sex"));
		tmpbean.setPhonenumber(rs.getString("phonenumber"));
		tmpbean.setUser_born(rs.getDate("user_born"));
		tmpbean.setUser_address(rs.getString("user_address"));
		tmpbean.setUser_email(rs.getString("user_email"));
		tmpbean.setSelfassessment(rs.getString("selfassessment"));
		tmpbean.setHeadpic(rs.getString("headpic"));
		tmpbean.setDept_id(rs.getInt("dept_id"));
		tmpbean.setDept_name(rs.getString("dept_name"));
	}
    
}
