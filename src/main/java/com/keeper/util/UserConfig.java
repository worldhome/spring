package com.keeper.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.keeper.vo.User;

@Configuration
public class UserConfig {
	@Bean(name = "user")
	public User user() {
		User user = new User();
		user.setPassword("XXXX");
		return user;
	}
}
