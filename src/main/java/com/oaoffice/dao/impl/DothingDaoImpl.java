package com.oaoffice.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.util.DbFun;
import com.oaoffice.bean.*;
import com.oaoffice.dao.*;
import com.oaoffice.util.PagingVO;

public class DothingDaoImpl implements DothingDao {

	@SuppressWarnings("resource")
	
	public Integer insert(Dothing bean) {

		StringBuilder sb = new StringBuilder();
		sb.append(" Insert Into Dothing(dothing_describe,dothing_enddate,dothing_priority,dothing_result,");
		sb.append(" user_id)");
		sb.append("Values(?,?,?,?,?)");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getDothing_describe());
			pstmt.setObject(2, bean.getDothing_enddate());
			pstmt.setObject(3, bean.getDothing_priority());
			pstmt.setObject(4, bean.getDothing_result());
			pstmt.setObject(5, bean.getUser_id());

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

	
	public List<Dothing> list() {
		List<Dothing> list = new ArrayList<Dothing>();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT" ); 
		sb.append("  a.*," ); 
		sb.append("	b.user_realname," ); 
		sb.append("	d.role_name" ); 
		sb.append(" FROM" ); 
		sb.append("	`dothing` as a" ); 
		sb.append("	LEFT JOIN user b ON a.user_id = b.user_id" ); 
		sb.append("	LEFT JOIN user_role c ON c.user_id = b.user_id" ); 
		sb.append("	LEFT JOIN role d ON c.role_id = d.role_id ");
		
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Dothing tmpbean = null;
			while (rs.next()) {
				tmpbean = new Dothing();
				tmpbean.setDothing_id(rs.getInt("dothing_id"));
				tmpbean.setDothing_describe(rs.getString("dothing_describe"));
				tmpbean.setDothing_enddate(rs.getDate("dothing_enddate"));
				tmpbean.setDothing_priority(rs.getString("dothing_priority"));
				tmpbean.setDothing_result(rs.getString("dothing_result"));
				tmpbean.setUser_id(rs.getInt("user_id"));
				tmpbean.setUser_realname(rs.getString("user_realname"));
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
		sb.append(" delete from Dothing where dothing_id=?");
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

	
	public Integer update(Dothing bean) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" update Dothing Set ");
		sb.append(" dothing_describe=? ");
		sb.append(" ,dothing_enddate=? ");
		sb.append(" ,dothing_priority=? ");
		sb.append(" ,dothing_result=? ");
		sb.append(" ,user_id=? ");
		sb.append(" where dothing_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;
		// uname,upass,realName,gender,birthday
		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			show(bean, pstmt);

			num = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return num;
	}

	
	public Dothing load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Dothing");
		sb.append(" Where dothing_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dothing bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Dothing();

				show(rs, bean);
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
		sb.append(" select count(1) from Dothing");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return num;
	}

	
	public Dothing loadByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Dothing loadByNo(String no) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Dothing");
		sb.append(" Where dothing_describe=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dothing bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Dothing();

				show(rs, bean);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return bean;
	}

	
	public List<Dothing> listByName(String name) {
		List<Dothing> list = new ArrayList<Dothing>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Dothing");
		sb.append(" where dothing_describe like ?");
		String sql = sb.toString();

		name = "%" + name + "%";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, name);

			rs = pstmt.executeQuery();

			Dothing tmpbean = null;
			while (rs.next()) {
				tmpbean = new Dothing();
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

	
	public List<Dothing> queryAll(PagingVO page) {
		int begin = (page.getCurentPageNo() - 1) * page.getPageSize();
		int end = page.getPageSize();
		List<Dothing> list = new ArrayList<Dothing>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Dothing limit ?,?");
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

			Dothing tmpbean = null;

			while (rs.next()) {
				tmpbean = new Dothing();
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

	
	public Dothing getDothing(Dothing stu) {
		Dothing tmpbean = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Dothing");
		sb.append(" where dothing_describe=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, stu.getDothing_describe());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tmpbean = new Dothing();
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

	private void show(Dothing bean, PreparedStatement pstmt) throws SQLException {
		pstmt.setObject(1, bean.getDothing_describe());
		pstmt.setObject(2, bean.getDothing_enddate());
		pstmt.setObject(3, bean.getDothing_priority());
		pstmt.setObject(4, bean.getDothing_result());
		pstmt.setObject(5, bean.getUser_id());
		pstmt.setObject(6, bean.getDothing_id());
	}

	private void show(Dothing tmpbean, ResultSet rs) throws SQLException {
		tmpbean.setDothing_id(rs.getInt("dothing_id"));
		tmpbean.setDothing_describe(rs.getString("dothing_describe"));
		tmpbean.setDothing_enddate(rs.getDate("dothing_enddate"));
		tmpbean.setDothing_priority(rs.getString("dothing_priority"));
		tmpbean.setDothing_result(rs.getString("dothing_result"));
		tmpbean.setUser_id(rs.getInt("user_id"));
	}

	private void show(ResultSet rs, Dothing bean) throws SQLException {
		bean.setDothing_id(rs.getInt("dothing_id"));
		bean.setDothing_describe(rs.getString("dothing_describe"));
		bean.setDothing_enddate(rs.getDate("dothing_enddate"));
		bean.setDothing_priority(rs.getString("dothing_priority"));
		bean.setDothing_result(rs.getString("dothing_result"));
		bean.setUser_id(rs.getInt("user_id"));
	}

}
