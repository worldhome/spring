package com.keeper.impl;

import com.keeper.UserDao;
import com.keeper.vo.User;

public class User2DaoImpl implements UserDao {

	public int insert(User user) {
		System.out.println("User2DaoImpl");
		return 4;
	}

}
