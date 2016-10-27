package com.keeper.dao.impl;

import com.keeper.dao.UserDao;
import com.keeper.vo.User;

public class UserDaoImpl implements UserDao {

	public int insert(User user) {
		System.out.println("userDaoImpl");
		return 3;
	}

}
