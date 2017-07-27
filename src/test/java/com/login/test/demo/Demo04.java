package com.login.test.demo;

public class Demo04 {

	public static void main(String[] args) throws InterruptedException {

			
		ThreadTest threadTest01 = new ThreadTest();
		ThreadTest02 threadTest02 = new ThreadTest02();
		threadTest01.setName("thread01");
		threadTest02.setName("thread02");
		threadTest01.setDaemon(true);
		threadTest01.start();
		threadTest02.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().isDaemon());
		
//		while(true){
//			System.out.println(Thread.currentThread().activeCount());
//			Thread.currentThread().sleep(2000);
//		}
		
	}

}

class ThreadTest extends Thread{
	
	@Override
	public void run() {
		super.run();
		while(true){
			System.out.println(Thread.currentThread().getName() + " running..."+Thread.activeCount()+Thread.currentThread().isDaemon());
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}


class ThreadTest02 extends Thread{
	
	@Override
	public void run() {
		super.run();
		int i = 0;
		while(i < 5){
			System.out.println(Thread.currentThread().getName() + " running..."+Thread.activeCount()+Thread.currentThread().isDaemon());
			try {
				i++;
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}