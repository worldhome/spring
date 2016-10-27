package com.keeper.impl;

import com.keeper.UserDao;
import com.keeper.vo.User;

public class UserDaoImpl implements UserDao {

	public int insert(User user) {
		System.out.println("userDaoImpl");
		return 3;
	}

}
