package com.login.test.demo;

import java.util.ArrayList;
import java.util.List;

public class Demo18  extends Thread{
	
	private Integer total = 0;
	
	private List<Integer> array;
	
	Demo18(List<Integer> list){
		this.setArray(list);
	}

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Integer> array = new ArrayList<Integer>(1000);
		for (int i = 1; i <= 1000; i++) {
			array.add(i);
		}
		Demo18 demo18_1 = new Demo18(array.subList(0, 200));
		Demo18 demo18_2 = new Demo18(array.subList(200, 400));
		Demo18 demo18_3 = new Demo18(array.subList(400, 600));
		Demo18 demo18_4 = new Demo18(array.subList(600, 800));
		Demo18 demo18_5 = new Demo18(array.subList(800, 1000));
		
		demo18_1.start();
		demo18_2.start();
		demo18_3.start();
		demo18_4.start();
		demo18_5.start();
		
		demo18_1.join();
		demo18_2.join();
		demo18_3.join();
		demo18_4.join();
		demo18_5.join();
		
		Integer total = 0;
		total = total + demo18_1.getTotal();
		total = total + demo18_2.getTotal();
		total = total + demo18_3.getTotal();
		total = total + demo18_4.getTotal();
		total = total + demo18_5.getTotal();
		
		System.out.println(total);
		
		
	}

	
	public void run() {
		for (Integer integer : array) {
			total = total + integer;
		}
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}


	public List<Integer> getArray() {
		return array;
	}


	public void setArray(List<Integer> list) {
		this.array = list;
	}

}
