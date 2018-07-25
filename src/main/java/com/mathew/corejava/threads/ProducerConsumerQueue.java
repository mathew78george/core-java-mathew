package com.mathew.corejava.threads;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProducerConsumerQueue {

	public static void main(String[] args) {
		DataHolderQueue queue = new DataHolderQueue(1000);
		MessageProducer producer1 = new MessageProducer(queue, 1, 400);
		MessageProducer producer2 = new MessageProducer(queue, 400, 1000);
		MessageConsumer consumer = new MessageConsumer(queue);
		producer1.start();
		producer2.start();
		consumer.start();
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int ii = 0; ii < 10; ii++) {
			DataHolderQueue.pushMessage1("test");
			queue.test2();
		}

		try {
			producer1.join();
			producer2.join();
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testQueueAndPriorityQueue() {
		Queue<String> queue = new PriorityQueue<String>();
		queue.add("AAAA");
		queue.add("EEEE");
		queue.add("QQQQ");
		queue.add("GGGG");
		queue.add("FFFF");
		queue.add("BBBB");
		queue.add("DDDD");
		queue.add("CCCC");
		int size = queue.size();
		for (int ii = 0; ii < size; ii++) {
			System.out.println(queue.poll());
		}
		Queue<String> queue2 = new LinkedList<String>();
		queue2.add("AAAA");
		queue2.add("EEEE");
		queue2.add("QQQQ");
		queue2.add("GGGG");
		queue2.add("FFFF");
		queue2.add("BBBB");
		queue2.add("DDDD");
		queue2.add("CCCC");
		size = queue2.size();
		System.out.println("=====================");
		for (int ii = 0; ii < size; ii++) {
			System.out.println(queue2.poll());
		}
	}
}

class DataHolderQueue {

	int capacity = 10;
	Queue<String> queue = new LinkedList<String>();

	public DataHolderQueue(int c) {
		capacity = c;
	}

	public synchronized static void pushMessage1(String mgs) {
		System.out.println("Inside static synchronized method");
		return;
	}

	public synchronized void test2() {
		System.out.println("Inside non static synchronized method");
		return;
	}

	public synchronized boolean pushMessage(String mgs) {
		if (queue.size() == capacity) {
			try {
				wait();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		boolean success = queue.add(mgs);
		return success;
	}

	public synchronized String readNextMessage() {
		if (queue.isEmpty()) {
			try {
				System.out.println("Before Wait");
				wait();
				System.out.println("After Wait");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		return queue.poll();
	}

}

class MessageProducer extends Thread {
	private DataHolderQueue dataQueue;
	private int start;
	private int end;

	public MessageProducer(DataHolderQueue q, int s, int e) {
		dataQueue = q;
		start = s;
		end = e;
	}

	public void run() {
		for (int ii = start; ii < end; ii++) {
			dataQueue.pushMessage("Message " + ii);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MessageConsumer extends Thread {
	private DataHolderQueue dataQueue;

	public MessageConsumer(DataHolderQueue q) {
		dataQueue = q;
	}

	public void run() {
		for (int ii = 0; ii < 1000; ii++) {
			System.out.println(dataQueue.readNextMessage());
		}
	}
}
