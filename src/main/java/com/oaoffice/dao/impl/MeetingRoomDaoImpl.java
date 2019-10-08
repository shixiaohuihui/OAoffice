package com.oaoffice.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.bean.MeetingRoom;
import com.oaoffice.dao.MeetingRoomDao;
import com.oaoffice.util.DbFun;
import com.oaoffice.util.PagingVO;

public class MeetingRoomDaoImpl implements MeetingRoomDao {

	@SuppressWarnings("resource")
	
	public Integer insert(MeetingRoom bean) {
		StringBuilder sb = new StringBuilder();
		sb.append(" Insert Into meetingroom(meetingroom_name,usercount) ");
		sb.append("Values(?,?)");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getMeetingroom_name());
			pstmt.setObject(2, bean.getUsercount());

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

	
	public List<MeetingRoom> list() {
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from meetingroom ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			MeetingRoom tmpbean = null;
			while (rs.next()) {
				tmpbean = new MeetingRoom();
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
		sb.append(" delete from MeetingRoom where meetingroom_id=?");
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

	
	public Integer update(MeetingRoom bean) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" update meetingroom Set ");
		sb.append(" meetingroom_name=? ");
		sb.append(" ,usercount=? ");
		sb.append(" where meetingroom_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;
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

	
	public MeetingRoom load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from meetingroom");
		sb.append(" Where meetingroom_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MeetingRoom bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new MeetingRoom();

				bean.setMeetingroom_id(rs.getInt("meetingroom_id"));
				bean.setMeetingroom_name(rs.getString("meetingroom_name"));
				bean.setUsercount(rs.getString("usercount"));
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
		sb.append(" select count(1) from meetingroom");
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

	
	public MeetingRoom loadByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public MeetingRoom loadByNo(String no) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from meetingroom");
		sb.append(" Where meetingroom_name=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MeetingRoom bean = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new MeetingRoom();

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

	
	public List<MeetingRoom> listByName(String name) {
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from meetingroom");
		sb.append(" where meetingroom_name like ?");
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

			MeetingRoom tmpbean = null;
			while (rs.next()) {
				tmpbean = new MeetingRoom();
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

	
	public List<MeetingRoom> queryAll(PagingVO page) {
		int begin = (page.getCurentPageNo() - 1) * page.getPageSize();
		int end = page.getPageSize();
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from meetingroom limit ?,?");
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

			MeetingRoom tmpbean = null;

			while (rs.next()) {
				tmpbean = new MeetingRoom();
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

	
	public MeetingRoom getMeetingRoom(MeetingRoom stu) {
		MeetingRoom tmpbean = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from meetingroom");
		sb.append(" where meetingroom_name=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, stu.getMeetingroom_name());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tmpbean = new MeetingRoom();
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

	private void show(MeetingRoom bean, PreparedStatement pstmt) throws SQLException {
		pstmt.setObject(1, bean.getMeetingroom_name());
		pstmt.setObject(2, bean.getUsercount());
		pstmt.setObject(3, bean.getMeetingroom_id());
	}

	private void show(MeetingRoom tmpbean, ResultSet rs) throws SQLException {
		tmpbean.setMeetingroom_id(rs.getInt("meetingroom_id"));
		tmpbean.setMeetingroom_name(rs.getString("meetingroom_name"));
		tmpbean.setUsercount(rs.getString("usercount"));
	}

	private void show(ResultSet rs, MeetingRoom bean) throws SQLException {
		bean.setMeetingroom_id(rs.getInt("meetingroom_id"));
		bean.setMeetingroom_name(rs.getString("meetingroom_name"));
		bean.setUsercount(rs.getString("usercount"));
	}

}
