package com.login.test.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class Demo14 {

	public static void main(String[] args) throws InterruptedException {

		Demo14 demo14 = new Demo14();
		
		ArrayList<String> strs = new ArrayList<String>(){{
			add("1");
			add("3");
			add("2");
			add("1");
		}};
		
		strs.add("1");
		strs.add("3");
		strs.add("2");
		strs.add("1");
		
		Collections.sort(strs);
		Collections.reverse(strs);
		
//		System.out.println(strs);
		
//		System.out.println(Collections.max(strs));
//		System.out.println(Collections.min(strs));
//		System.out.println(Collections.indexOfSubList(strs, new ArrayList<String>(){{add("2");add("2");}}));
		
		/**     enumeration       */
//		Enumeration<String> en = Collections.enumeration(strs);
//		while(en.hasMoreElements()){
//			System.out.println(en.nextElement());
//		}
		
		
		List<Integer> ints = Arrays.asList(1, 2, 5, 4);
		System.out.println(ints);
		
		demo14.method("2");
		
		Stack stack = new Stack();
		stack.add(1);
		stack.add(3);
		stack.pop();
		System.out.print(stack);
		
		Hashtable hashtable = new Hashtable();
		hashtable.put(2, 222);
		System.out.print(hashtable);
		
		ArrayList list = new ArrayList();
		
		list.add("23");
		list.add(24);
		list.add(new Demo14());
		System.out.println(list);
		
	}
	
	public <T> void method(T s){
		System.out.println(s.getClass());
	}

}
