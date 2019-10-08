package com.oaoffice.dao.impl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.util.DbFun;
import com.oaoffice.bean.*;
import com.oaoffice.dao.*;
import com.oaoffice.util.PagingVO;

public class FloderDaoImpl implements FloderDao {

	@SuppressWarnings("resource")
	
	public Integer insert(Floder bean) {

		StringBuilder sb = new StringBuilder();
		sb.append(" Insert Into Floder(floder_name,floder_content,floder_path,floder_isshare,");
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
			pstmt.setObject(1, bean.getFloder_name());
			pstmt.setObject(2, bean.getFloder_content());
			pstmt.setObject(3, bean.getFloder_path());
			pstmt.setObject(4, bean.getFloder_isshare());
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

	
	public List<Floder> list() {
		List<Floder> list = new ArrayList<Floder>();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("	b.floder_id,");
		sb.append("	b.floder_name,");
		sb.append("	b.floder_content,");
		sb.append("	b.floder_path,");
		sb.append("	b.floder_isshare,");
		sb.append("	b.user_id,");
		sb.append("	a.user_realname");
		sb.append(" FROM");
		sb.append("	user as a"); 
		sb.append("	LEFT JOIN floder b ON a.user_id = b.user_id ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Floder tmpbean = null;
			while (rs.next()) {
				tmpbean = new Floder();
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
		sb.append(" delete from Floder where floder_id=?");
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

	
	public Integer update(Floder bean) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" update Floder Set ");
		sb.append(" floder_name=? ");
		sb.append(" ,floder_content=? ");
		sb.append(" ,floder_path=? ");
		sb.append(" ,floder_isshare=? ");
		sb.append(" ,user_id=? ");
		sb.append(" where floder_id=?");
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

	
	public Floder load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("	b.floder_id,");
		sb.append("	b.floder_name,");
		sb.append("	b.floder_content,");
		sb.append("	b.floder_path,");
		sb.append("	b.floder_isshare,");
		sb.append("	b.user_id,");
		sb.append("	a.user_realname");
		sb.append(" FROM");
		sb.append("	user as a"); 
		sb.append("	LEFT JOIN floder b ON a.user_id = b.user_id ");
		sb.append(" Where floder_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Floder bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Floder();

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
		sb.append(" select count(1) from Floder");
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

	
	public Floder loadByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Floder loadByNo(String no) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Floder");
		sb.append(" Where floder_name=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Floder bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Floder();

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

	
	public List<Floder> listByName(String name) {
		List<Floder> list = new ArrayList<Floder>();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("	b.floder_id,");
		sb.append("	b.floder_name,");
		sb.append("	b.floder_content,");
		sb.append("	b.floder_path,");
		sb.append("	b.floder_isshare,");
		sb.append("	b.user_id,");
		sb.append("	a.user_realname");
		sb.append(" FROM");
		sb.append("	user as a"); 
		sb.append("	LEFT JOIN floder b ON a.user_id = b.user_id ");
		sb.append(" where floder_name like ?");
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

			Floder tmpbean = null;
			while (rs.next()) {
				tmpbean = new Floder();
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

	
	public List<Floder> queryAll(PagingVO page) {
		int begin = (page.getCurentPageNo() - 1) * page.getPageSize();
		int end = page.getPageSize();
		List<Floder> list = new ArrayList<Floder>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Floder limit ?,?");
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

			Floder tmpbean = null;

			while (rs.next()) {
				tmpbean = new Floder();
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

	
	public Floder getFloder(Floder stu) {
		Floder tmpbean = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Floder");
		sb.append(" where floder_name=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, stu.getFloder_name());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tmpbean = new Floder();
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

	private void show(Floder bean, PreparedStatement pstmt) throws SQLException {
		pstmt.setObject(1, bean.getFloder_name());
		pstmt.setObject(2, bean.getFloder_content());
		pstmt.setObject(3, bean.getFloder_path());
		pstmt.setObject(4, bean.getFloder_isshare());
		pstmt.setObject(5, bean.getUser_id());
		pstmt.setObject(6, bean.getFloder_id());
	}

	private void show(Floder tmpbean, ResultSet rs) throws SQLException {
		tmpbean.setFloder_id(rs.getInt("floder_id"));
		tmpbean.setFloder_name(rs.getString("floder_name"));
		tmpbean.setFloder_content(rs.getString("floder_content"));
		tmpbean.setFloder_path(rs.getString("floder_path"));
		tmpbean.setFloder_isshare(rs.getInt("floder_isshare"));
		tmpbean.setUser_id(rs.getInt("user_id"));
		tmpbean.setUser_realname(rs.getString("user_realname"));
	}

	private void show(ResultSet rs, Floder bean) throws SQLException {
		bean.setFloder_id(rs.getInt("floder_id"));
		bean.setFloder_name(rs.getString("floder_name"));
		bean.setFloder_content(rs.getString("floder_content"));
		bean.setFloder_path(rs.getString("floder_path"));
		bean.setFloder_isshare(rs.getInt("floder_isshare"));
		bean.setUser_id(rs.getInt("user_id"));
		bean.setUser_realname(rs.getString("user_realname"));
	}

}
