package com.login.test.demo;

import java.util.HashSet;
import java.util.Iterator;

public class Demo21 {

	public static void main(String[] args) {
		
		int i=10;
//		System.out.println(i+=i-=i*=i);
		System.out.println(i+=i-=i*=i+=i);
		
		HashSet hs = new HashSet();
		
		hs.add(1);
		hs.add(2);
		hs.add(3);
		
		Iterator iterator = hs.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}

}
