package com.login.test.demo;

public class Demo extends ClassB{

	
	static boolean str;
	
	static {System.out.println("this is Demo static block");}
	
	Demo(){
		System.out.println("this is Demo constructor");
	}
	
	public static void main(String[] args) throws InterruptedException {

		Demo demo  = new Demo();
		
	}

}

class ClassB extends Thread {


	static {System.out.println("this is ClassB static block");}
	
	
	ClassB(){
		System.out.println("this is classB constructor");
	}
	
}