package com.login.test.demo;

public class Demo07 extends Demo08 implements Interface01, Interface02 {
	
	static {
		System.out.println("this is static block in Demo07....");
	}
	
	{
		System.out.println("this is instance block in Demo07....");
	}

	static String str = "str";
	
	
	@Override
	public void method(){
//		super.method();
		System.out.println("method be executed in Demo07.method()...");
	}
	
	public void method(String str){
		super.method();
		System.out.println("method be executed in Demo07.method(string)...");
	}
	
	public static void main(String[] args) {

//		int i = Integer.MAX_VALUE;
//		float f = Float.MAX_VALUE;
//		
//		System.out.println(i + 1);
//		System.out.println(f + 1);
//		
//		float fNa = Float.NaN;
//		Double.longBitsToDouble(0);
//		System.out.println(fNa > 1 || fNa <= 1);
//		System.out.println(Float.SIZE);
//		System.out.println(Double.NaN);
//		System.out.println(Double.SIZE);
//		System.out.println(Double.longBitsToDouble(0));
		
		System.out.println();
		Demo07 demo07 = new Demo07();
//		demo07.str = "this string be changed in Demo07";
		System.out.println(demo07.str);// implement two interface and extend the one same static final variable, will warning ambiguous, unless override this variable in current class
		demo07.method("");
	}

}
