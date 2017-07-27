package com.login.test.demo;

import java.util.ArrayList;
import java.util.HashMap;

public class Demo03 {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

//		String str = "str01";
//		String str1 = new String("str01");
//		System.out.println(str == str1);
		
		String str = "str01";
		String str1 = new String("str01");
		String str2 = "";
		System.out.println(str2.equals(null));
		System.out.println(str.hashCode());//109771762
		System.out.println(str1.hashCode());//109771762
		
//		HashMap hashMap = new HashMap(1);
//		
//		ArrayList arrayList = new ArrayList(1);
//		
//		hashMap.put(null, null);
//		hashMap.put(null, "this is null value.");
//		hashMap.put(1, 111);
//		hashMap.put(2, 222);
//		
//		arrayList.add(1);
//		arrayList.add(2);
//		
//		System.out.println(hashMap);
//		System.out.println(hashMap.keySet());
//		
//		System.out.println(arrayList);
		
		
	}

}
