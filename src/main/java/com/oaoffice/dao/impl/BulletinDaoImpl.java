package com.oaoffice.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.util.DbFun;
import com.oaoffice.bean.*;
import com.oaoffice.dao.*;
import com.oaoffice.util.PagingVO;

public class BulletinDaoImpl implements BulletinDao {

	@SuppressWarnings("resource")
	public Integer insert(Bulletin bean) {

		StringBuilder sb = new StringBuilder();
		sb.append(" Insert Into Bulletin(bulletin_title,bulletin_content,bulletin_buildtime,user_realname,");
		sb.append(" user_id,role_id)");
		sb.append("Values(?,?,?,?,?,?)");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getBulletin_title());
			pstmt.setObject(2, bean.getBulletin_content());
			pstmt.setObject(3, bean.getBulletin_buildtime());
			pstmt.setObject(4, bean.getUser_realname());
			pstmt.setObject(5, bean.getUser_id());
			pstmt.setObject(6, bean.getRole_id());

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

	
	public List<Bulletin> list() {
		List<Bulletin> list = new ArrayList<Bulletin>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Bulletin ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Bulletin tmpbean = null;
			while (rs.next()) {
				tmpbean = new Bulletin();
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

	
	public Integer delete(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" delete from Bulletin where Bulletin_id=?");
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

	
	public Integer update(Bulletin bean) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" update Bulletin Set ");
		sb.append(" bulletin_title=? ");
		sb.append(" ,bulletin_content=? ");
		sb.append(" ,bulletin_buildtime=? ");
		sb.append(" ,user_realname=? ");
		sb.append(" ,user_id=? ");
		sb.append(" ,role_id=? ");
		sb.append(" where bulletin_id=?");
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
	
	
	public Bulletin load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Bulletin");
		sb.append(" Where Bulletin_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Bulletin bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Bulletin();

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
		sb.append(" select count(1) from Bulletin");
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

	
	public Bulletin loadByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Bulletin loadByNo(String no) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Bulletin");
		sb.append(" Where Bulletin_title=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Bulletin bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Bulletin();

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

	
	public List<Bulletin> listByName(String name) {
		List<Bulletin> list = new ArrayList<Bulletin>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Bulletin");
		sb.append(" where Bulletin_title like ?");
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

			Bulletin tmpbean = null;
			while (rs.next()) {
				tmpbean = new Bulletin();
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

	
	public List<Bulletin> queryAll(PagingVO page) {
		int begin = (page.getCurentPageNo() - 1) * page.getPageSize();
		int end = page.getPageSize();
		List<Bulletin> list = new ArrayList<Bulletin>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Bulletin limit ?,?");
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

			Bulletin tmpbean = null;

			while (rs.next()) {
				tmpbean = new Bulletin();
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

	
	public Bulletin getBulletin(Bulletin stu) {
		Bulletin tmpbean = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Bulletin");
		sb.append(" where Bulletin_title=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, stu.getBulletin_title());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tmpbean = new Bulletin();
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

	private void show(Bulletin bean, PreparedStatement pstmt) throws SQLException {
		pstmt.setObject(1, bean.getBulletin_title());
		pstmt.setObject(2, bean.getBulletin_content());
		pstmt.setObject(3, bean.getBulletin_buildtime());
		pstmt.setObject(4, bean.getUser_realname());
		pstmt.setObject(5, bean.getUser_id());
		pstmt.setObject(6, bean.getRole_id());
		pstmt.setObject(7, bean.getBulletin_id());
	}

	private void show(Bulletin tmpbean, ResultSet rs) throws SQLException {
		tmpbean.setBulletin_id(rs.getInt("bulletin_id"));
		tmpbean.setBulletin_title(rs.getString("bulletin_title"));
		tmpbean.setBulletin_content(rs.getString("bulletin_content"));
		tmpbean.setBulletin_buildtime(rs.getDate("bulletin_buildtime"));
		tmpbean.setUser_realname(rs.getString("user_realname"));
		tmpbean.setUser_id(rs.getInt("user_id"));
		tmpbean.setRole_id(rs.getInt("role_id"));
	}

	private void show(ResultSet rs, Bulletin bean) throws SQLException {
		bean.setBulletin_id(rs.getInt("bulletin_id"));
		bean.setBulletin_title(rs.getString("bulletin_title"));
		bean.setBulletin_content(rs.getString("bulletin_content"));
		bean.setBulletin_buildtime(rs.getDate("bulletin_buildtime"));
		bean.setUser_realname(rs.getString("user_realname"));
		bean.setUser_id(rs.getInt("user_id"));
		bean.setRole_id(rs.getInt("role_id"));
	}

}
