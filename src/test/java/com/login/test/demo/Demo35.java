package com.login.test.demo;

public class Demo35 {
	
	private static Demo35 demo35;
	
	public static synchronized Demo35 getInstance(){
		if(demo35 == null){
			demo35 = new Demo35();
		}
		return demo35;
	}

	public static void main(String[] args) {
		Demo35 demo35 = Demo35.getInstance();
		System.out.println(demo35);
	}

}
