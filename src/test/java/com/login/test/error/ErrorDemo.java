package com.login.test.error;

public class ErrorDemo {

	public static void main(String[] args) {
		
		Error error = new Error("what...");
		
//		throw error;
		
		RuntimeException exception = new RuntimeException("throw runtime exception...");
		
		throw exception;

	}

}
