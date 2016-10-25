package com.keeper.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class KeepMethodBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("##方法被调用之前##");
	}

}
