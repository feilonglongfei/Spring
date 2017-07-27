package com.login.test.demo;

import java.io.IOException;

public class Demo11 {

	public static void main(String[] args) {

		
		try{
			throw new IOException();
		} catch (java.io.FileNotFoundException ex){
//			ex.printStackTrace();
			System.out.println("FileNotFoundException!");
		} catch (IOException ex){
//			ex.printStackTrace();
			System.out.println("IOException!");
		} catch (Exception ex){
//			ex.printStackTrace();
			System.out.println("Exception!");
		} 
		
		String s = null;

        System.out.println("s=" + s);//if not initialize, will compile error
		
	}

}
