package com.login.test.javaIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

public class BufferedReaderTest {

	public static void main(String[] args) throws IOException {

		String lineString;
		File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\0603\\test.txt");
//		Reader fileReader = new FileReader("C:\\Users\\Administrator\\Desktop\\temp\\0603\\test.txt");
		Reader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
//		while ((lineString = bufferedReader.readLine()) != null){
//			System.out.println(lineString);
//		}
		
		char[] cbuf = new char[100];
		fileReader.read(cbuf);
		System.out.println(cbuf);
		
		Writer fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.append("come from bufferwriter");
		bufferedWriter.flush();

		bufferedReader.close();
		bufferedWriter.close();
		
	}
}
