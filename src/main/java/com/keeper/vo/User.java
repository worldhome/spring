package com.keeper.vo;

import java.util.Date;

public class User extends Parent {

	private String userName;
	private String password;
	private Date registerDate;

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", registerDate=" + registerDate + "]";
	}

	public void init() {
		this.password = "123455";
	}

	public void destroy() {
		this.password = "777777";
	}
}
