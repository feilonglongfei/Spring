/**
 * 
 */
package com.login.test.demo;

/**
 * @author Administrator
 *
 */
public class Demo25 {

	public void method(int[] ints){
		for(int i=0; i<ints.length; i++){
			ints[i] = ints[i] +1;
		}
	}
	
	public void method01(int in){
		in = 999;
	}
	
	public void method02(String str){
		str = "str updated in mehtod02";
	}
	
	public void method03(Demo25Inner demo25Inner){
		demo25Inner.userName = "user name udpate in method03...";
		demo25Inner.i = 1;
		demo25Inner.d = (double) 11;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] ints = {1, 3, 5, 7, 9};
		String str = new String("str initial...");
		
		Demo25 demo25 = new Demo25();
		Demo25Inner demo25Inner = new Demo25Inner("user name", 0, (double) 10);
//		demo25.method(ints);
		demo25.method01(ints[0]);
		demo25.method02(str);
		demo25.method03(demo25Inner);
		for (int i : ints) {
			System.out.println(i);
		}
		System.out.println(str);
		System.out.println(demo25Inner.userName + "; " + demo25Inner.i + "; " + demo25Inner.d);
	}
}

class Demo25Inner {
	
	String userName;
	int i;
	Double d;
	
	Demo25Inner(String userName, int i, Double d){
		this.userName = userName;
		this.i = i;
		this.d = d;
	}
}