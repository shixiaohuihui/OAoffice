package com.oaoffice.dao;

import java.util.List;

import com.oaoffice.bean.MeetingRoom;
import com.oaoffice.util.PagingVO;

public interface MeetingRoomDao {
	Integer insert(MeetingRoom bean);// 添加一行，返回新增行的主键值

	Integer delete(Integer id);// 删除一行，传入主键值，返回受影响行数

	Integer update(MeetingRoom bean);// 根据一行，根据主键值修改，返回受影响行数

	List<MeetingRoom> list();// 返回所有行的数据

	MeetingRoom load(Integer id); // 加载主键为指定值的行，不存在则返回null

	Integer count(); // 返回所有行的数量

	MeetingRoom loadByName(String name); // 加载名称为指定值的行，不存在则返回null

	Integer countByName(String name); // 返回名称为指定值的所有行的数量

	MeetingRoom loadByNo(String no); // 加载no为指定值的行，不存在则返回null

	List<MeetingRoom> listByName(String name); // 加载名称为指定值的行，不存在则返回null

	List<MeetingRoom> queryAll(PagingVO page);// 分页查询

	MeetingRoom getMeetingRoom(MeetingRoom pMeetingRoom);
}
