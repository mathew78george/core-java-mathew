package com.mathew.corejava.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchronizedHashMapWithReadWriteLock {

	private Map<Integer, String> map = new HashMap<Integer, String>();
	private ReadWriteLock lock = new ReentrantReadWriteLock(true);
	Lock writeLock = lock.writeLock();
	Lock readLock = lock.readLock();

	public SynchronizedHashMapWithReadWriteLock() {

	}

	public void put(Integer key, String value) {
		try {
			writeLock.lock();
			map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}

	public void remove(Integer key) {
		try {
			writeLock.lock();
			map.remove(key);
		} finally {
			writeLock.unlock();
		}
	}

	public String get(Integer key) {
		try {
			readLock.lock();
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}

}
