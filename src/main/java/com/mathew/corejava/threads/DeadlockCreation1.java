package com.mathew.corejava.threads;

public class DeadlockCreation1 {
	public static void main(String[] args) throws Exception {
		Object o1 = new Object();
		Object o2 = new Object();
		A a1 = new A(o1, o2);
		A a2 = new A(o2, o1);
		Thread thread1 = new Thread(a1, "Thread-1");
		Thread thread2 = new Thread(a2, "Thread-2");
		thread1.start();
		thread2.start();
	}
}

class A implements Runnable {
	private Object obj1;
	private Object obj2;

	public A(Object o1, Object o2) {
		obj1 = o1;
		obj2 = o2;
	}

	public void run() {

		synchronized (obj1) {

			/*
			 * Adding this optional delay so that Thread-2 could enough time to lock Object
			 * class and form deadlock. If you remove this sleep, because of threads
			 * unpredictable behavior it might that Thread-1 gets completed even before
			 * Thread-2 is started and we will never form deadLock.
			 */

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + " has acquired lock "
					+ "on Obj1  and waiting to acquire lock on Obj2...");
			synchronized (obj2) {
				System.out.println(Thread.currentThread().getName() + " has acquired lock on Obj2 class");
			}
		}

		System.out.println(Thread.currentThread().getName() + " has ENDED");
	}
}

class B implements Runnable {
	public void run() {

		synchronized (Object.class) {
			System.out.println(Thread.currentThread().getName() + " has acquired "
					+ "lock on Object class and waiting to acquire lock on String class...");

			/*
			 * Adding this optional delay so that Thread-1 could enough time to lock String
			 * class and form deadlock. If you remove this sleep, because of threads
			 * unpredictable behavior it might that Thread-2 gets completed even before
			 * Thread-1 is started and we will never form deadLock.
			 */

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName() + " has acquired lock on String class");
			}
		}

		System.out.println(Thread.currentThread().getName() + " has ENDED");
	}
}
