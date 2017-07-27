package com.login.test.demo;

public class Demo26 {
	
	public void method(int i, String...strings){
		
		System.out.println(i);
		
		for (String string : strings) {
			System.out.println(string);
		}
	}

	public static void main(String[] args) {

		Demo26 demo26 = new Demo26();
		
		demo26.method(444, "1", "22", "333");
		
	}

}

