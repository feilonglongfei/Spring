package com.login.Util.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo extends Thread {

	public static void main(String[] args) {

		ArrayList<String> strs = new ArrayList<String>();

		String s = "jakdjdiidkddddddddlllllllllllllllllin!";

		getSubStrings(s.replace("!", ""), strs);

		Comparator<? super String> compare = new Comparator<String>() {

			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()){
					return 1;
				}
				return -1;
			}
		};
		Collections.sort(strs, compare);
		
		if(strs.isEmpty()){
			System.out.println("no repeat strs");
		} else {
			System.out.println(strs.get(strs.size() - 1));
		}
		
//		Random random = new Random();
//		
//		HashSet<Integer> randoms = new HashSet<Integer>();
//
//		while(randoms.size() < 300){
//			randoms.add(random.nextInt(1000));
//		}
//		ArrayList<Integer> randomsList = new ArrayList<Integer>();
//		randomsList.addAll(randoms);
//		Collections.sort(randomsList);
//		System.out.println(randomsList.size());
//		System.out.println(randomsList);
		
//		System.out.println(f("125dd521"));
		
		ThreadDemo threadDemo = new ThreadDemo();
		threadDemo.start();
	}

	private static void getSubStrings(String s, ArrayList<String> strs) {

		if (s.length() > 1) {

			int length = 1;

			while (s.charAt(0) == s.charAt(length)) {
				length++;
			}
			if (length > 1) {
				strs.add(s.substring(0, length));
			}
			getSubStrings(s.substring(length, s.length()), strs);
		}
	}
	
	private static int f(String s){
		
		int i=0, j = s.length() -1;
		
		while(i < j ){
			if(s.charAt(i) == s.charAt(j)){
				i++;
				j--;
			} else {
				return 0;
			}
		}
		return 1;
	}
	
	
	static class ThreadDemo extends Thread {
		
		@Override
		public void run() {
			super.run();
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
