package com.login.test.demo;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class Demo24 {

	public static void main(String[] args) {

		HashMap hashMap = new HashMap();
		hashMap.put('a', 55);
		hashMap.put(5, 55);
		hashMap.put(7, 77);
		hashMap.put(4, 88);
		hashMap.put(6, 66);
		System.out.println(hashMap);
		
		TreeMap treeMap = new TreeMap();
		treeMap.put(9, 55);
		treeMap.put(5, 55);
		treeMap.put(7, 77);
		treeMap.put(4, 88);
		treeMap.put(6, 66);
		System.out.println(treeMap);
		
	}
	
	
}
