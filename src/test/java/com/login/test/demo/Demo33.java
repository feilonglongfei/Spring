package com.login.test.demo;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Demo33 implements Serializable {
	
	
	public void method() throws UnknownHostException, IOException{
		Socket socket = new Socket("127.0.0.1", 80);
		
		ServerSocket serverSocket = new ServerSocket();
	}

	public static void main(String[] args) {
		int x = 1 ,y = 2 , z = 3;
		
		System.out.println(y+=z--/++x);
		
		int a = 3;
		System.out.println("a 非的结果是："+(~a));
				
	}

}
