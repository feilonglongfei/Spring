package com.login.test.javaIO;

import java.io.IOException;
import java.io.StringReader;

public class StringReaderTest {

	public static void main(String[] args) throws IOException {

		StringReader stringReader = new StringReader("ddd");
		
		char[] chars = new char[100];
		stringReader.read(chars);
		
		System.out.println(chars);
		
	}

}
