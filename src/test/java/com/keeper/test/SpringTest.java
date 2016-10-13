package com.keeper.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import com.keeper.UserDao;
import com.keeper.util.AppConfig;
import com.keeper.vo.TUser;
import com.keeper.vo.User;
import com.keeper.vo.UserGroup;

public class SpringTest {
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) context.getBean("user1");
		System.out.println(user.getUserName());
		System.out.println(user.getRegisterDate());
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
	 * list set array map property
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

	/**
	 * parent
	 */
	@Test
	public void test4() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) applicationContext.getBean("user8");
		System.out.println(user.toString());
	}

	/**
	 * test5
	 */
	@Test
	public void test5() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) applicationContext.getBean("user7");
		System.out.println(user.toString());
	}

	/**
	 * init-method destroy-method
	 */
	@Test
	public void test6() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) applicationContext.getBean("user9");
		System.out.println(user.toString());
	}

	@Test
	public void test7(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		TUser user = (TUser) applicationContext.getBean(TUser.class);
		System.out.println(user.toString());
	}
	
	
	public static void main(String[] args) {
		/**
		 * 0.5%以上 1分 0.4%-0.5% 0.8分 0.3%-0.4% 0.6分 0.2%-0.3% 0.4分 0.2%以下 0.2分
		 */
		FelEngine fel = new FelEngineImpl();
		FelContext ctx = fel.getContext();
		ctx.set("i", 0.23);
		Object result = fel.eval("i>0.5?1:((i>=0.4&&i<=0.5)?0.8:((i>=0.3&&i<0.4)?0.6:((i>=0.2&&i<0.3)?0.4:((i<0.2)?0.2:0))))");
		System.out.println(result);
	}
}
