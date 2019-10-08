package com.oaoffice.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.bean.Meeting;
import com.oaoffice.dao.MeetingDao;
import com.oaoffice.util.DbFun;
import com.oaoffice.util.PagingVO;

public class MeetingDaoImpl implements MeetingDao {

	@SuppressWarnings("resource")
	
	public Integer insert(Meeting bean) {
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into meeting(meeting_title,meeting_date,meeting_start,meeting_end,meeting_status,meetingroom_id) ");
		sb.append("values(?,?,?,?,?,?)");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getMeeting_title());
			pstmt.setObject(2, bean.getMeeting_date());
			pstmt.setObject(3, bean.getMeeting_start());
			pstmt.setObject(4, bean.getMeeting_end());
			pstmt.setObject(5, bean.getMeeting_status());
			pstmt.setObject(6, bean.getMeetingroom_id());

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

	
	public List<Meeting> list() {
		List<Meeting> list = new ArrayList<Meeting>();
		StringBuilder sb = new StringBuilder();
		sb.append(
				" select a.*,b.meetingroom_name from meeting a left join meetingroom b on a.meeting_id = b.meetingroom_id ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Meeting tmpbean = null;
			while (rs.next()) {
				tmpbean = new Meeting();
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
		sb.append(" delete from Meeting where Meeting_id=?");
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

	
	public Integer update(Meeting bean) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" update meeting Set ");
		sb.append(" Meeting_title=? ");
		sb.append(" ,Meeting_date=? ");
		sb.append(" ,Meeting_start=? ");
		sb.append(" ,Meeting_end=? ");
		sb.append(" ,Meeting_status=? ");
		sb.append(" ,meetingroom_id=? ");
		sb.append(" where Meeting_id=?");
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

	
	public Meeting load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Meeting");
		sb.append(" Where Meeting_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Meeting bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Meeting();

				bean.setMeeting_title(rs.getString("Meeting_title"));
				bean.setMeeting_date(rs.getDate("Meeting_date"));
				bean.setMeeting_start(rs.getTime("Meeting_start"));
				bean.setMeeting_end(rs.getTime("Meeting_end"));
				bean.setMeeting_status(rs.getString("Meeting_status"));
				bean.setMeetingroom_id(rs.getInt("Meetingroom_id"));
				bean.setMeeting_id(rs.getInt("Meeting_id"));
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
		sb.append(" select count(1) from Meeting");
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

	
	public Meeting loadByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Meeting loadByNo(String no) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Meeting");
		sb.append(" Where Meeting_title=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Meeting bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Meeting();

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

	
	public List<Meeting> listByName(String name) {
		List<Meeting> list = new ArrayList<Meeting>();
		StringBuilder sb = new StringBuilder();
		// sb.append(" select * from Meeting");
		sb.append("select a.*,b.meetingroom_name from meeting a left join meetingroom b on a.meeting_id = b.meetingroom_id");
		sb.append(" where Meeting_title like ?");
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

			Meeting tmpbean = null;
			while (rs.next()) {
				tmpbean = new Meeting();
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

	
	public List<Meeting> queryAll(PagingVO page) {
		Integer begin = (page.getCurentPageNo() - 1) * page.getPageSize();
		Integer end = page.getPageSize();
		List<Meeting> list = new ArrayList<Meeting>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Meeting limit ?,?");
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

			Meeting tmpbean = null;

			while (rs.next()) {
				tmpbean = new Meeting();
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

	
	public Meeting getMeeting(Meeting stu) {
		Meeting tmpbean = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Meeting");
		sb.append(" where Meeting_title=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, stu.getMeeting_title());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tmpbean = new Meeting();
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

	private void show(Meeting bean, PreparedStatement pstmt) throws SQLException {
		pstmt.setObject(1, bean.getMeeting_title());
		pstmt.setObject(2, bean.getMeeting_date());
		pstmt.setObject(3, bean.getMeeting_start());
		pstmt.setObject(4, bean.getMeeting_end());
		pstmt.setObject(5, bean.getMeeting_status());
		pstmt.setObject(6, bean.getMeetingroom_id());
		pstmt.setObject(7, bean.getMeeting_id());

	}

	private void show(Meeting tmpbean, ResultSet rs) throws SQLException {
		tmpbean.setMeeting_id(rs.getInt("Meeting_id"));
		tmpbean.setMeeting_title(rs.getString("Meeting_title"));
		tmpbean.setMeeting_date(rs.getDate("Meeting_date"));
		tmpbean.setMeeting_start(rs.getTime("Meeting_start"));
		tmpbean.setMeeting_end(rs.getTime("Meeting_end"));
		tmpbean.setMeeting_status(rs.getString("Meeting_status"));
		tmpbean.setMeetingroom_id(rs.getInt("Meetingroom_id"));
		tmpbean.setMeetingroom_name(rs.getString("Meetingroom_name"));
	}

	private void show(ResultSet rs, Meeting tmpbean) throws SQLException {
		tmpbean.setMeeting_id(rs.getInt("Meeting_id"));
		tmpbean.setMeeting_title(rs.getString("Meeting_title"));
		tmpbean.setMeeting_date(rs.getDate("Meeting_date"));
		tmpbean.setMeeting_start(rs.getTime("Meeting_start"));
		tmpbean.setMeeting_end(rs.getTime("Meeting_end"));
		tmpbean.setMeeting_status(rs.getString("Meeting_status"));
		tmpbean.setMeetingroom_id(rs.getInt("Meetingroom_id"));
	}

}
