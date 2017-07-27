package com.login.test.demo;

public class Demo19 {
	
	static private Demo19 demo19 = new Demo19();
	
	synchronized static public Demo19 getSingleton(){
		return demo19;
	}

	public static void main(String[] args) {
		Demo19 demo19 = Demo19.getSingleton();
		System.out.println(demo19);
	}

}
