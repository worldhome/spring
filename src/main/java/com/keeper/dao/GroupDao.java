package com.keeper.dao;

import java.util.List;

import com.keeper.vo.Group;

public interface GroupDao {
	public int insert(Group group);

	public Group getGroupById(String pk);

	public Group getGroupById2(String pk);

	public List<Group> getGroupList();

	public int[] insert(List<Group> groupList);
}
