package com.login.test.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo23 {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\0603\\log.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String lineStr = null;
		while((lineStr = reader.readLine()) != null){
			System.out.println(lineStr);
		}
		
	}

}
