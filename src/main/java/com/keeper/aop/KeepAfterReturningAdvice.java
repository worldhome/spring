package com.keeper.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class KeepAfterReturningAdvice implements AfterReturningAdvice {

	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("######afterReturning######开始执行#####");
		System.out.println(arg0);
	}

}
