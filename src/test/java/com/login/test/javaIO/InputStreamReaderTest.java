package com.login.test.javaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class InputStreamReaderTest {

	public static void main(String[] args) throws IOException {

		
		String lineString;
		File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\0603\\13 挪威森林.mp3");
		File fileCopy = new File("C:\\Users\\Administrator\\Desktop\\temp\\0603\\13 挪威森林_copy.mp3");
//		Reader fileReader = new FileReader("C:\\Users\\Administrator\\Desktop\\temp\\0603\\test.txt");
		Reader fileReader = new FileReader(file);
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		
		byte[] cbuf = new byte[1024];
		int temp = 0;
//		inputStreamReader.read(cbuf, 0, 100);
//		System.out.println(cbuf);
		
//		byte[] b = new byte[100];
//		inputStream.read(b);
//		for(int i=0; i<b.length; i++){
//			System.out.print(b[i]);
//		}
		
		
		FileOutputStream outputSteam = new FileOutputStream(fileCopy);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputSteam);
		
		while((temp = inputStream.read(cbuf, 0, 1024)) != -1){
			outputSteam.write(cbuf, 0, temp);
		}
		
		outputStreamWriter.flush();
		inputStreamReader.close();
		outputStreamWriter.close();
		
	}

}
