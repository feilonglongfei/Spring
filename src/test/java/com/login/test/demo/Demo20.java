package com.login.test.demo;

public class Demo20 extends Demo20_Inner {
	
	Demo20() {
		System.out.println();
//		super();//Constructor call must be the first statement in a constructor
	}
	
	@Override
	public void method(){
		System.out.println();
		super.method();
		System.out.println();
	}
	
	public void method(String str){
		
	}

	public static void main(String[] args) {
		new Demo20().method();
		try {
			
		} catch(Throwable th) {
			
		}
	}

}


class Demo20_Inner {
	public void method(){
		System.out.println("this is Demo20_Inner.method()...");
	}
}