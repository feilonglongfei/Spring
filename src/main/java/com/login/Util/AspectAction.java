package com.login.Util;

public interface AspectAction {
	
	public void doBefore();
	
	public void doAfter();

	public void doAfterThrow(Throwable ex);
}
