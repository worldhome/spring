package com.keeper.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.keeper.UserDao;
import com.keeper.util.AppConfig;
import com.keeper.vo.User;
import com.keeper.vo.UserGroup;

public class SpringTest {
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) context.getBean("user1");
		System.out.println(user.getUserName());
		user = (User) context.getBean("user3");
		System.out.println(user.getUserName());
	}

	/**
	 * javaConfig
	 */
	@Test
	public void test1() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		User user = (User) context.getBean("user");
		System.out.println(user.getPassword());
	}

	/**
	 * type
	 */
	@Test
	public void test2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = context.getBean(UserDao.class);
		userDao.insert(null);
	}

	/**
	 * list
	 */
	@Test
	public void test3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserGroup userGroup = context.getBean(UserGroup.class);
		List<User> userList = userGroup.getUserList();
		if (userList != null && userList.size() > 0) {
			for (User user : userList) {
				System.out.println(user);
			}
		}
		User[] users = userGroup.getUsers();
		for (User user : users) {
			System.out.println(user.toString());
		}
		System.out.println(userGroup.getMap());
		System.out.println(userGroup.getProperties());
	
	}
}
