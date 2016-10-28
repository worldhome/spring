package com.keeper.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.keeper.dao.GroupDao;
import com.keeper.vo.Group;

public class GroupDaoImpl extends JdbcDaoSupport implements GroupDao {
	@Transactional
	public int insert(Group group) {
		String sql = "insert into TBL_GROUP(GROUP_NAME,DESCRIPTION) values(?,?)";
		return this.getJdbcTemplate().update(sql, new Object[] { group.getGroupName(), group.getDescription() });
	}

	public int[] insert(List<Group> groupList) {
		String sql = "insert into TBL_GROUP(GROUP_NAME,DESCRIPTION) values(:groupName,:description)";
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(groupList.toArray());
		List<Object[]> objectParams = new ArrayList<Object[]>();
		objectParams.add(params);
		return this.getJdbcTemplate().batchUpdate(sql, objectParams);
	}

	public Group getGroupById(String pk) {
		String sql = "select * from TBL_GROUP where GROUP_NAME=?";
		return this.getJdbcTemplate().queryForObject(sql, new Object[] { pk }, new GroupRowMapper());
	}

	public Group getGroupById2(String pk) {
		String sql = "select * from TBL_GROUP where GROUP_NAME=?";
		return this.getJdbcTemplate().queryForObject(sql, new Object[] { pk }, new BeanPropertyRowMapper<Group>(Group.class));
	}

	public List<Group> getGroupList() {
		String sql = "select * from TBL_GROUP ";
		return this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Group>(Group.class));
	}
}
