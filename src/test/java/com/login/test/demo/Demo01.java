package com.login.test.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo01 {

	public static void main(String[] args) {
		
		ArrayList<Integer> integers = new ArrayList<Integer>();
		
		integers.add(1);
		integers.add(7);
		integers.add(5);
		integers.add(2);
		
		Collections.sort(integers, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(o1 >= o2){
					return -1;
				}
				return 0;
			}
		});
		
		System.out.println(integers);

	}

}
