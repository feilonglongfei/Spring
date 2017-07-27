package com.login.test.demo;

public class Demo09 implements Interface01 {

	public void method() {
		System.out.println("this is Demo09.method()....");

	}

	public static void main(String[] args) {

		Interface01 interface01 = new Demo07();
		
		interface01.method();//
		
		System.out.println(interface01 instanceof Interface01);
		System.out.println(interface01 instanceof Demo07);
		System.out.println(interface01 instanceof Demo09);
		
	}

}
