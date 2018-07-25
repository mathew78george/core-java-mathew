package com.mathew.corejava.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConsumerObject {
	
	Stack<String> stack = new Stack<String>();

	Map<Integer, String> cache = new HashMap<Integer, String>();
	int test;
	public ConsumerObject() {

	}

	public boolean addObject(Integer key, String value) {
		synchronized (cache) {
			cache.put(key, value);
		}
		return true;
	}

	public static void main(String[] args) {
		ConsumerObject obj = new ConsumerObject();
		ProucerThread p1 = new ConsumerObject().new ProucerThread(obj, 0, 100);
		ProucerThread p2 = new ConsumerObject().new ProucerThread(obj, 100,600);
		ProucerThread p3 = new ConsumerObject().new ProucerThread(obj, 600, 800);
		ProucerThread p4 = new ConsumerObject().new ProucerThread(obj, 800, 1300);
		ProucerThread p5 = new ConsumerObject().new ProucerThread(obj, 1300, 80000);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(p4);
		Thread t5 = new Thread(p5);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		try {
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName());
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj.cache.size());
		
	}

	class ProucerThread implements Runnable {

		ConsumerObject object;
		int start;
		int end;

		public ProucerThread(ConsumerObject o, int s, int e) {
			object = o;
			start = s;
			end = e;
		}

		public void run() {
			for (int ii = start; ii < end; ii++) {
				object.addObject(new Integer(ii), "Test" + ii);
			}

		}

	}
}
