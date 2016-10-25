package com.keeper.aop;

import org.springframework.aop.ThrowsAdvice;

public class KeepThrowsAdvice implements ThrowsAdvice {

	public void afterThrowing(RuntimeException exception) {
		System.out.println("HijackThrowException : Throw exception hijacked!");
	}
}
