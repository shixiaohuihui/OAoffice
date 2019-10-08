package com.oaoffice.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oaoffice.bean.Dept;
import com.oaoffice.dao.DeptDao;
import com.oaoffice.util.DbFun;
import com.oaoffice.util.PagingVO;

public class DeptDaoImpl implements DeptDao {

	@SuppressWarnings({ "resource", "null" })
	
	public Integer insert(Dept bean) {
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into dept(dept_name,dept_description) ");
		sb.append(" values(?,?) ");
		String sql = sb.toString();

		// 声明三大对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Integer num = 0;
		try {
			conn = DbFun.getConn();
			System.out.println(bean.getDept_name());
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getDept_name());
			pstmt.setObject(2, bean.getDept_description());

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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}
		return num;
	}

	
	public Integer delete(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" delete from dept where  dept_id=?");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		Integer num = 0;

		try {
			conn = DbFun.getConn();
			pst = conn.prepareStatement(sql);
			pst.setObject(1, id);
			num = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pst, conn);
		}

		return num;
	}

	
	public Integer update(Dept bean) {
		StringBuilder sb= new StringBuilder();
		sb.append(" update dept set dept_name = ?");
		sb.append(",dept_description = ? ");
		sb.append("where dept_id= ?");
		String sql=sb.toString();
		System.out.println(sql);
		Connection conn=null;
		PreparedStatement st=null;
		Integer num=0;
		
		try {
			conn=DbFun.getConn();
			st=conn.prepareStatement(sql);
			st.setObject(1, bean.getDept_name());
			st.setObject(2, bean.getDept_description());
			st.setObject(3, bean.getDept_id());
			num=st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbFun.close(null, st, conn);
		}
		
		return num;
	}

	
	public List<Dept> list() {
		List<Dept> list = new ArrayList<Dept>();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from dept ");
		String sql = sb.toString();
		Dept bean = null;
		// 声明三大对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DbFun.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new Dept();
				setBean(bean, rs);
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, pstmt, conn);
		}

		return list;
	}

	private void setBean(Dept bean, ResultSet rs) throws SQLException {
		bean.setDept_id(rs.getString("dept_id"));
		bean.setDept_name(rs.getString("dept_name"));
		bean.setDept_description(rs.getString("dept_description"));
	}

	
	public Dept load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from dept where dept_id= ? ");
		String sql = sb.toString();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Dept bean = null;

		try {
			conn = DbFun.getConn();
			ps = conn.prepareStatement(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				bean = new Dept();
				setBean(bean, rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbFun.close(rs, ps, conn);
		}

		return bean;
	}

	
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Dept loadByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Dept loadByNo(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Dept> listByName(String name) {
		List<Dept> list =new ArrayList<Dept>();
		StringBuilder sb=new StringBuilder();
		sb.append(" select * from dept where dept_name like ? ");
		String sql=sb.toString();
		Dept bean =null;
		
		name = "%"+ name+ "%";
		
		Connection conn=null;
		PreparedStatement  st=null;
		ResultSet rs=null;
		
		try {
			conn = DbFun.getConn();
			st=conn.prepareStatement(sql);
			st.setObject(1, name);
			rs=st.executeQuery();
			
			while(rs.next()) {
				bean=new Dept();
				setBean(bean, rs);
				list.add(bean);;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	
	public List<Dept> queryAll(PagingVO page) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Dept getDept(Dept stu) {
		// TODO Auto-generated method stub
		return null;
	}

}
