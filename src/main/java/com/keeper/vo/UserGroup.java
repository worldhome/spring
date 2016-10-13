package com.keeper.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

public class UserGroup {

	private List<User> userList;
	private User[] users;
	private Map<String, User> map;
	@Autowired
	private User user202;
	private Properties properties;

	public User getUser202() {
		return user202;
	}

	public void setUser202(User user202) {
		this.user202 = user202;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public Map<String, User> getMap() {
		return map;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "UserGroup [userList=" + userList + ", users=" + Arrays.toString(users) + ", map=" + map + ", user=" + user202 + ", properties="
				+ properties + "]";
	}
	
}
