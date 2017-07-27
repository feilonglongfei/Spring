package com.login.test.demo;

public class Demo10 extends HelloA {
	public Demo10() {
		System.out.println("HelloB");
	}

	{
		System.out.println("I'm B class");
	}

	static {
		System.out.println("static B");
	}

	public static void main(String[] args) {

		System.out.println("-------main start-------");
		new Demo10();
		new Demo10();
		System.out.println("-------main end-------");
	}
}

class HelloA {

	public HelloA() {
		System.out.println("HelloA");
	}

	{
		System.out.println("I'm A class");
	}

	static {
		System.out.println("static A");
	}

}