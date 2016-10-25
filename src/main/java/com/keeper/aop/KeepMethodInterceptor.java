package com.keeper.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class KeepMethodInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("调用之前");
		Object obj = arg0.proceed();
		System.out.println("调用之后");
		return obj;
	}

}
