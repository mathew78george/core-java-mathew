package com.mathew.corejava.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSample {
	public static void main(String[] args) {
		SharedObject obj = new SharedObject();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int ii = 0; ii < 150; ii++) {
					obj.incrementCount();
				}

			}
		});
		t1.setName("Thread 1");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int ii = 0; ii < 150; ii++) {
					obj.incrementCount();
				}

			}
		});
		t2.setName("Thread 2");
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int ii = 0; ii < 150; ii++) {
					obj.incrementCount();
				}

			}
		});
		t3.setName("Thread 3");
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj.getCount());

	}

}

class SharedObject {
	int counter;
	ReentrantLock lock = new ReentrantLock();

	public SharedObject() {
		counter = 0;
	}

	public int getCount() {
		return counter;
	}

	public boolean incrementCount() {
		boolean lockAvailable = false;
		boolean success = false;
		try {
			lockAvailable = lock.tryLock(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (lockAvailable) {
			System.out.println(Thread.currentThread().getName());
			try {
				counter = counter + 1;
				success = true;
			} finally {
				lock.unlock();
			}
		}
		return success;
	}

}