package com.login.test.javaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectInputStreamReaderTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		File file = new File("C:\\Users\\Administrator\\Desktop\\temp\\0603\\objectInputStreamTest.txt");
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
		
		User user = new User("myUserName", "myPwd");
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user);
		userList.add(user);
		
		objectOutputStream.writeObject(userList);
		
		User userReader;
		
		ArrayList<User> userListReader = (ArrayList<User>) objectInputStream.readObject();
		
//		while((userReader = (User) objectInputStream.readObject()) != null){
//			System.out.println(userReader.getUserName().concat(";").concat(userReader.getPwd()));
//		}
		
		for (User userTemp : userListReader) {
			System.out.println(userTemp.getUserName().concat(";").concat(userTemp.getPwd()));
		}
		
		objectOutputStream.close();
		objectInputStream.close();
	}

}
