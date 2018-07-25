package com.mathew.corejava.threads;

public class ThreadLocalExample implements Runnable {
	private int globalvalue;

	ThreadLocal<String> name = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return "Mathew George";
		};
	};

	public ThreadLocalExample(int s) {
		globalvalue = s;
	}

	@Override
	public void run() {
		System.out.println("Thread name --> " + Thread.currentThread().getName() + " name--->" + name.get() + "--->"
				+ globalvalue);
		name.set("Reeba Mathew");
		globalvalue = globalvalue * 2;
		System.out.println("Thread name --> " + Thread.currentThread().getName() + " name--->" + name.get() + "--->"
				+ globalvalue);
	}

	public static void main(String[] args) {
		ThreadLocalExample tl = new ThreadLocalExample(10);
		Thread t1 = new Thread(tl, "T1");
		Thread t2 = new Thread(tl, "T2");
		Thread t3 = new Thread(tl, "T3");
		t1.start();
		t2.start();
		t3.start();
		tl.name.set(null);
	}

}
