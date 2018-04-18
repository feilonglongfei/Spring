package com.login.test.demo;

import java.util.Iterator;

public class Demo22  implements Iterable<Demo22Sub> {
	
	Demo22Sub[] demo22Subs = null;

	public static void main(String[] args) {

	}

	public Iterator<Demo22Sub> iterator() {
		return new Demo22SubIterator();
	}
	
	private class Demo22SubIterator implements Iterator<Demo22Sub> {
		
		private int index = 0;

		public boolean hasNext() {
			
			return false;
		}

		public Demo22Sub next() {
			return null;
		}

		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}

class Demo22Sub {
	
}
