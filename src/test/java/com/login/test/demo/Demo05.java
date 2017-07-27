package com.login.test.demo;


public class Demo05 {

	public static void main(String[] args) {

		try{
			System.out.println("this is try block ....");
			Demo05 demo05 = new Demo05();
			demo05.mehtod();
//			demo05.main(null);//Exception in thread "main" java.lang.StackOverflowError
			System.exit(0);
		} finally{
			System.out.println("this is finally block ....");
		}
		
		
	}
	
	private void mehtod(){
		try{
			System.out.println("this is method try block ....");
			return;
		} finally {
			System.out.println("this is method finally block ....");
		}
	}

}
