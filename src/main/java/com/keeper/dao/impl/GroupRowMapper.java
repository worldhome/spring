package com.keeper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.keeper.vo.Group;

public class GroupRowMapper implements RowMapper<Group> {

	public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		Group group = new Group();
		group.setGroupName(rs.getString("GROUP_NAME"));
		group.setDescription(rs.getString("DESCRIPTION"));
		return group;
	}

}
