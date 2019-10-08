package com.oaoffice.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.util.DbFun;
import com.oaoffice.bean.*;
import com.oaoffice.dao.*;
import com.oaoffice.util.PagingVO;

public class VacateDaoImpl implements VacateDao {

	@SuppressWarnings("resource")
	
	public Integer insert(Vacate bean) {

		StringBuilder sb = new StringBuilder();
		sb.append(" Insert Into Vacate(vacate_sharttime,vacate_time,vacate_reason,user_id,");
		sb.append(" approver,vacate_state,role_id)");
		sb.append("Values(?,?,?,?,?,?,?)");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getVacate_sharttime());
			pstmt.setObject(2, bean.getVacate_time());
			pstmt.setObject(3, bean.getVacate_reason());
			pstmt.setObject(4, bean.getUser_id());
			pstmt.setObject(5, bean.getApprover());
			pstmt.setObject(6, bean.getVacate_state());
			pstmt.setObject(7, bean.getRole_id());

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

	
	public List<Vacate> list() {
		List<Vacate> list = new ArrayList<Vacate>();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("	b.vacate_id,");
		sb.append("	b.vacate_sharttime,");
		sb.append("	b.vacate_time,");
		sb.append("	b.vacate_reason,");
		sb.append("	b.user_id,");
		sb.append("	b.approver,");
		sb.append("	b.vacate_state,");
		sb.append("	b.role_id,");
		sb.append("	a.user_realname");
		sb.append(" FROM");
		sb.append("	user as a"); 
		sb.append("	LEFT JOIN vacate b ON a.user_id = b.user_id ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Vacate tmpbean = null;
			while (rs.next()) {
				tmpbean = new Vacate();
				tmpbean.setVacate_id(rs.getInt("vacate_id"));
				tmpbean.setVacate_sharttime(rs.getDate("vacate_sharttime"));
				tmpbean.setVacate_time(rs.getString("vacate_time"));
				tmpbean.setVacate_reason(rs.getString("vacate_reason"));
				tmpbean.setUser_id(rs.getInt("user_id"));
				tmpbean.setApprover(rs.getString("approver"));
				tmpbean.setVacate_state(rs.getString("vacate_state"));
				tmpbean.setRole_id(rs.getInt("role_id"));
				tmpbean.setUser_realname(rs.getString("user_realname"));

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
		sb.append(" delete from Vacate where Vacate_id=?");
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

	
	public Integer update(Vacate bean) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" update Vacate Set ");
		sb.append(" vacate_sharttime=? ");
		sb.append(" ,vacate_time=? ");
		sb.append(" ,vacate_reason=? ");
		sb.append(" ,user_id=? ");
		sb.append(" ,approver=? ");
		sb.append(" ,vacate_state=? ");
		sb.append(" ,role_id=? ");
		sb.append(" where vacate_id=?");
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
	
	
	public Vacate load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("	b.vacate_id,");
		sb.append("	b.vacate_sharttime,");
		sb.append("	b.vacate_time,");
		sb.append("	b.vacate_reason,");
		sb.append("	b.user_id,");
		sb.append("	b.approver,");
		sb.append("	b.vacate_state,");
		sb.append("	b.role_id,");
		sb.append("	a.user_realname");
		sb.append(" FROM");
		sb.append("	user as a"); 
		sb.append("	LEFT JOIN vacate b ON a.user_id = b.user_id ");
		sb.append(" Where Vacate_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vacate bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Vacate();

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
		sb.append(" select count(1) from Vacate");
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

	
	public Vacate loadByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Vacate loadByNo(String no) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Vacate");
		sb.append(" Where Vacate_sharttime=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vacate bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Vacate();

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

	
	public List<Vacate> listByName(String name) {
		List<Vacate> list = new ArrayList<Vacate>();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("	b.vacate_id,");
		sb.append("	b.vacate_sharttime,");
		sb.append("	b.vacate_time,");
		sb.append("	b.vacate_reason,");
		sb.append("	b.user_id,");
		sb.append("	b.approver,");
		sb.append("	b.vacate_state,");
		sb.append("	b.role_id,");
		sb.append("	a.user_realname");
		sb.append(" FROM");
		sb.append("	user as a"); 
		sb.append("	LEFT JOIN vacate b ON a.user_id = b.user_id ");
		sb.append(" where Vacate_sharttime like ?");
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

			Vacate tmpbean = null;
			while (rs.next()) {
				tmpbean = new Vacate();
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

	
	public List<Vacate> queryAll(PagingVO page) {
		int begin = (page.getCurentPageNo() - 1) * page.getPageSize();
		int end = page.getPageSize();
		List<Vacate> list = new ArrayList<Vacate>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Vacate limit ?,?");
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

			Vacate tmpbean = null;

			while (rs.next()) {
				tmpbean = new Vacate();
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

	
	public Vacate getVacate(Vacate stu) {
		Vacate tmpbean = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Vacate");
		sb.append(" where Vacate_sharttime=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, stu.getVacate_sharttime());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tmpbean = new Vacate();
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

	private void show(Vacate bean, PreparedStatement pstmt) throws SQLException {
		pstmt.setObject(1, bean.getVacate_sharttime());
		pstmt.setObject(2, bean.getVacate_time());
		pstmt.setObject(3, bean.getVacate_reason());
		pstmt.setObject(4, bean.getUser_id());
		pstmt.setObject(5, bean.getApprover());
		pstmt.setObject(6, bean.getVacate_state());
		pstmt.setObject(7, bean.getRole_id());
		pstmt.setObject(8, bean.getVacate_id());
	}

	private void show(Vacate tmpbean, ResultSet rs) throws SQLException {
		tmpbean.setVacate_id(rs.getInt("vacate_id"));
		tmpbean.setVacate_sharttime(rs.getDate("vacate_sharttime"));
		tmpbean.setVacate_time(rs.getString("vacate_time"));
		tmpbean.setVacate_reason(rs.getString("vacate_reason"));
		tmpbean.setUser_id(rs.getInt("user_id"));
		tmpbean.setApprover(rs.getString("approver"));
		tmpbean.setVacate_state(rs.getString("vacate_state"));
		tmpbean.setRole_id(rs.getInt("role_id"));
		tmpbean.setUser_realname(rs.getString("user_realname"));
	}

	private void show(ResultSet rs, Vacate bean) throws SQLException {
		bean.setVacate_id(rs.getInt("vacate_id"));
		bean.setVacate_sharttime(rs.getDate("vacate_sharttime"));
		bean.setVacate_time(rs.getString("vacate_time"));
		bean.setVacate_reason(rs.getString("vacate_reason"));
		bean.setUser_id(rs.getInt("user_id"));
		bean.setApprover(rs.getString("approver"));
		bean.setVacate_state(rs.getString("vacate_state"));
		bean.setRole_id(rs.getInt("role_id"));
		bean.setUser_realname(rs.getString("user_realname"));
	}

}
