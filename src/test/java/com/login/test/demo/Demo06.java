package com.login.test.demo;

public class Demo06 {
	
	static public Boolean flag = false;

	public static void main(String[] args) throws InterruptedException {
		Thread01 thread01 = new Thread01();
		Thread02 thread02 = new Thread02();

		thread01.start();
		thread02.start();

//		thread01.join();
//		thread02.join();

		while(Thread.currentThread().activeCount() > 1){
			System.out.println("this is main runing..." + Thread.currentThread().activeCount());
			Thread.sleep(1000);
		}
		
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
	}

}

class Thread01 extends Thread {

	@Override
	public void run() {
		super.run();

		try {
			synchronized (Demo06.flag) {
				if(!Demo06.flag){
					Demo06.flag.wait();
				}
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 2; i++) {
			System.out.println("this is thread01 runing..." + Thread.currentThread().activeCount());
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class Thread02 extends Thread {

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 2; i++) {
			System.out.println("this is thread02 runing..." + Thread.currentThread().activeCount());
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
//		Demo06.flag = true;
		synchronized (Demo06.flag) {
			Demo06.flag.notify();
		}
		
		try {
			this.method();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void method() throws Exception{
		throw new Exception("exception from thread02...");
	}
}