package com.mathew.corejava.designs;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
	int hitCounts[];
	Queue<Integer> hitQueue = new LinkedList<Integer>();
	int size = 60;
	boolean isStarted;
	long starttime;
	long timeSpanInSec;

	public HitCounter(int minutes) {
		hitCounts = new int[60];
		isStarted = false;
		timeSpanInSec = minutes * 60;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis() / 1000;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis() / 1000;
		long delta = end - start;
		System.out.println(delta);
	}

	public void registerHit() {
		if (!isStarted) {
			starttime = System.currentTimeMillis() / 1000;
			isStarted = true;
		}
		// hitQueue.
		long end = System.currentTimeMillis() / 1000;
		int index = (int) (end - starttime);
		System.out.println(index);
		hitCounts[index] = hitCounts[index] + 1;
	}

}
