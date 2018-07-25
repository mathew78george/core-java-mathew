package com.mathew.corejava.threads;

public class DeamonThread {

	public static void main(String[] args) {
		MyDeamonThread deamon = new MyDeamonThread();
		deamon.setDaemon(true);
//		deamon.start();
		NormalThread normal = new NormalThread();
		normal.start();
		
//		try {
//			deamon.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("Done");
	}
}

class MyDeamonThread extends Thread {

	public void run() {
		for (int ii = 0; ii < 2000; ii++) {
			System.out.println("MyDeamonThread --> " + ii);
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class NormalThread extends Thread {

	public void run() {
		for (int ii = 0; ii < 1000; ii++) {
			System.out.println("NormalThread --> " + ii);
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}