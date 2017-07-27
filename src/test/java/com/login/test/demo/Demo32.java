package com.login.test.demo;

public class Demo32 {
	
	private int i;
	
	public Demo32(String str){
		
	}
	
	public Demo32(int i){
		this.setI(i);
//		this(new String(""));
	}
	
	public Demo32(int i, String str){
		this(str);
		this.setI(i);
	}
	

	public static void main(String[] args) {

	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void method(){
//		this(new String(""));
	}
}
