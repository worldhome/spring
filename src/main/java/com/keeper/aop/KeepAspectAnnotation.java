package com.keeper.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class KeepAspectAnnotation {
	@Pointcut("execution(* com.keeper.impl.*.*(..))")
	public void pointCut() {

	}

	@After("pointCut()")
	public void after(JoinPoint joinPoint) {
		System.out.println("after");
	}

	@AfterReturning(pointcut = "pointCut()", returning = "returnObj")
	public void afterReturning(JoinPoint joinPoint, Object returnObj) {
		System.out.println("afterReturning=" + returnObj);
	}

	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before");
	}

	@AfterThrowing(pointcut = "pointCut()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println("afterThrowing");
	}

	@Around(value = "pointCut()")
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
