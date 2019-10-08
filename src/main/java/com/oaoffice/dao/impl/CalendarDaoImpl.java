package com.oaoffice.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.util.DbFun;
import com.oaoffice.bean.Calendar;
import com.oaoffice.dao.CalendarDao;
import com.oaoffice.util.PagingVO;

public class CalendarDaoImpl implements CalendarDao {

	@SuppressWarnings("resource")
	
	public Integer insert(Calendar bean) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" Insert Into Calendar(calendar_title,calendar_starttime,calendar_endtime,calendar_remind,");
		sb.append(" calendar_content,user_id)");
		sb.append("Values(?,?,?,?,?,?)");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getCalendar_title());
			pstmt.setObject(2, bean.getCalendar_starttime());
			pstmt.setObject(3, bean.getCalendar_endtime());
			pstmt.setObject(4, bean.getCalendar_remind());
			pstmt.setObject(5, bean.getCalendar_content());
			pstmt.setObject(6, bean.getUser_id());

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

	
	public List<Calendar> list() {
		List<Calendar> list = new ArrayList<Calendar>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Calendar ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Calendar tmpbean = null;
			while (rs.next()) {
				tmpbean = new Calendar();
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
		sb.append(" delete from Calendar where Calendar_id=?");
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

	
	public Integer update(Calendar bean) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" update Calendar Set ");
		sb.append(" Calendar_title=? ");
		sb.append(" ,calendar_starttime=? ");
		sb.append(" ,calendar_endtime=? ");
		sb.append(" ,calendar_remind=? ");
		sb.append(" ,calendar_content=? ");
		sb.append(" ,user_id=? ");
		sb.append(" where Calendar_id=?");
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

	
	public Calendar load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Calendar");
		sb.append(" Where Calendar_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Calendar bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Calendar();

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
		sb.append(" select count(1) from Calendar");
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

	
	public Calendar loadByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Calendar loadByNo(String no) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Calendar");
		sb.append(" Where Calendar_name=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Calendar bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Calendar();

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

	
	public List<Calendar> listByName(String name) {
		List<Calendar> list = new ArrayList<Calendar>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Calendar");
		sb.append(" where Calendar_title like ?");
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

			Calendar tmpbean = null;
			while (rs.next()) {
				tmpbean = new Calendar();
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

	
	public List<Calendar> queryAll(PagingVO page) {
		int begin = (page.getCurentPageNo() - 1) * page.getPageSize();
		int end = page.getPageSize();
		List<Calendar> list = new ArrayList<Calendar>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Calendar limit ?,?");
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

			Calendar tmpbean = null;

			while (rs.next()) {
				tmpbean = new Calendar();
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

	
	public Calendar getCalendar(Calendar stu) {
		Calendar tmpbean = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Calendar");
		sb.append(" where calendar_title=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, stu.getCalendar_title());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tmpbean = new Calendar();
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

	private void show(Calendar bean, PreparedStatement pstmt) throws SQLException {
		pstmt.setObject(1, bean.getCalendar_title());
		pstmt.setObject(2, bean.getCalendar_starttime());
		pstmt.setObject(3, bean.getCalendar_endtime());
		pstmt.setObject(4, bean.getCalendar_remind());
		pstmt.setObject(5, bean.getCalendar_content());
		pstmt.setObject(6, bean.getUser_id());
		pstmt.setObject(7, bean.getCalendar_id());
	}

	private void show(Calendar tmpbean, ResultSet rs) throws SQLException {
		tmpbean.setCalendar_id(rs.getInt("Calendar_id"));
		tmpbean.setCalendar_title(rs.getString("calendar_title"));
		tmpbean.setCalendar_starttime(rs.getDate("calendar_starttime"));
		tmpbean.setCalendar_endtime(rs.getDate("calendar_endtime"));
		tmpbean.setCalendar_remind(rs.getString("calendar_remind"));
		tmpbean.setCalendar_content(rs.getString("calendar_content"));
		tmpbean.setUser_id(rs.getInt("user_id"));
	}

	private void show(ResultSet rs, Calendar bean) throws SQLException {
		bean.setCalendar_id(rs.getInt("Calendar_id"));
		bean.setCalendar_title(rs.getString("Calendar_title"));
		bean.setCalendar_starttime(rs.getDate("calendar_starttime"));
		bean.setCalendar_endtime(rs.getDate("calendar_endtime"));
		bean.setCalendar_remind(rs.getString("calendar_remind"));
		bean.setCalendar_content(rs.getString("calendar_content"));
		bean.setUser_id(rs.getInt("user_id"));
	}

}
