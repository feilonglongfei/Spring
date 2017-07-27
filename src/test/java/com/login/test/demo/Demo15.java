package com.login.test.demo;

public class Demo15 {
	
	public String str = new String("str");
	
	public void methodOuter(){
		System.out.println("this is Demo15.methodOuter...");
	}
	
	class Demo15Inner {
		
		public void method(){
			methodOuter();
		}
	}
	

	public static void main(String[] args) {

		
	}

}


