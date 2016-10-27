package com.keeper.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.keeper.dao.GroupDao;
import com.keeper.vo.Group;

public class GroupDaoImpl extends JdbcDaoSupport implements GroupDao {
	public int insert(Group group) {
		String sql = "insert into TBL_GROUP(GROUP_NAME,DESCRIPTION) values(?,?)";
		return this.getJdbcTemplate().update(sql, new Object[] { group.getGroupName(), group.getDescription() });
	}
}
