package com.login.test.demo;

public class Demo08 {
	
	static {
		System.out.println("this is static block in Demo08....");
	}
	
	{
		System.out.println("this is instance block in Demo08....");
	}

	static String str = "str";
	
	public void method(){
		System.out.println("method be executed in Demo08.method()...");
	}

	public static void main(String[] args) {

	}

}
