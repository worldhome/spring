package com.keeper.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class KeepAspect {

	public void after(JoinPoint joinPoint) {
		System.out.println("after");
	}

	public void afterReturning(JoinPoint joinPoint, Object returnObj) {
		System.out.println("afterReturning=" + returnObj);
	}

	public void before(JoinPoint joinPoint) {
		System.out.println("before");
	}

	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println("afterThrowing");
	}

	public Object around(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		try {
			System.out.println("around1");
			obj = joinPoint.proceed();
			System.out.println("around2");
			return obj;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
}
