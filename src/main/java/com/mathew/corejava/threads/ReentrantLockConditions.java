package com.mathew.corejava.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConditions {

	public static void main(String[] args) {
		DataHolder data = new DataHolder(25);
		MessageProducerLock producer1 = new MessageProducerLock(data, 0, 100);
		MessageProducerLock producer2 = new MessageProducerLock(data, 100, 200);
		MessageConsumerLock consumer1 = new MessageConsumerLock(data);
		ExecutorService executer = Executors.newFixedThreadPool(5);
		executer.execute(producer1);
		executer.execute(producer2);
		executer.execute(consumer1);
		executer.shutdown();
	}
}

class MessageProducerLock implements Runnable {
	private DataHolder dataQueue;
	private int start;
	private int end;

	public MessageProducerLock(DataHolder q, int s, int e) {
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

class MessageConsumerLock implements Runnable {
	private DataHolder dataQueue;

	public MessageConsumerLock(DataHolder q) {
		dataQueue = q;
	}

	public void run() {
		for (int ii = 0; ii < 1000; ii++) {
			System.out.println(dataQueue.readNextMessage());
		}
	}
}

class DataHolder {
	Queue<String> queue;
	int capacity = 10;
	ReentrantLock lock = new ReentrantLock(true);
	Condition stackEmpty = lock.newCondition();
	Condition stackFull = lock.newCondition();

	public DataHolder(int c) {
		capacity = c;
		queue = new LinkedList<String>();
	}

	public boolean pushMessage(String msg) {
		boolean success = false;
		try {
			lock.lock();
			if (queue.size() == capacity) {
				stackFull.await();
			}
			success = queue.add(msg);
		} catch (InterruptedException e) {

		} finally {
			stackEmpty.signalAll();
			lock.unlock();
		}
		return success;
	}

	public String readNextMessage() {
		String nextMessage = null;
		try {
			lock.lock();
			if (queue.isEmpty()) {
				System.out.println("Queue is empty..waiting");
				stackEmpty.await();
			}
			nextMessage = queue.poll();
		} catch (InterruptedException e) {

		} finally {
			stackFull.signalAll();
			lock.unlock();			
		}
		return nextMessage;
	}
}