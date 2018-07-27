package com.mathew.corejava.designs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class HitCounter {
	Deque<TimeSlot> hitQueue = new ArrayDeque<TimeSlot>();
	int hitQueueSize;
	boolean isStarted;
	long starttime;

	public HitCounter(int size) {
		hitQueueSize = size;
		isStarted = false;
		starttime = System.currentTimeMillis() / 1000;
	}

	public static void test(String[] args) {
		Queue<String> hitQueue1 = new ArrayDeque<String>();
		hitQueue1.add("ONE");
		hitQueue1.add("TWO");
		hitQueue1.add("THREE");
		// System.out.println(hitQueue1.peek());
		// System.out.println(hitQueue1.peek());
		// System.out.println(hitQueue1.peek());

		Deque<String> hitQueue2 = new ArrayDeque<String>();
		hitQueue2.add("ONE");
		hitQueue2.add("TWO");
		hitQueue2.add("THREE");
		hitQueue2.add("FOUR");
		System.out.println(hitQueue2.getFirst());
		System.out.println(hitQueue2.getLast());
		System.out.println(hitQueue2.poll());
		System.out.println(hitQueue2.poll());
		// hitQueue1.peek()
		// System.out.println(hitQueue1.pop());
	}

	public static void main(String[] args) {
		HitCounter counter = new HitCounter(60);
		CleanupTask task = new CleanupTask(counter);
		Timer cleantimer = new Timer("CleanupTask Timer", true);
		cleantimer.scheduleAtFixedRate(task, 0, counter.hitQueueSize * 1000);
		GetHitTask gethitTask = new GetHitTask(counter);
		Timer gethittimer = new Timer("GetHitTask Timer", true);
		gethittimer.scheduleAtFixedRate(gethitTask, 100, 2000);
		for (int ii = 0; ii < 1000; ii++) {
			try {
				counter.registerHit();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int getHits() {
		int hits = 0;
		for (Iterator<TimeSlot> timeslotIter = hitQueue.iterator(); timeslotIter.hasNext();) {
			TimeSlot slot = timeslotIter.next();
			hits = hits + slot.hitCount;
		}
		return hits;
	}

	public void cleanUp() {
		long currentTime = System.currentTimeMillis() / 1000;
		long before = currentTime - hitQueueSize;
		while (hitQueue.size() > 0 && hitQueue.getFirst().getTime() < before) {
			System.out.println("current time " + currentTime);
			System.out.println("before " + before);
			System.out.println("hitQueue.getLast().getTime()" + hitQueue.getFirst().getTime());
			synchronized (hitQueue) {
				hitQueue.removeFirst();
			}
			System.out.println("==================================");
		}
	}

	public void registerHit() {
		long currentTime = System.currentTimeMillis() / 1000;
		if (!isStarted) {
			starttime = System.currentTimeMillis() / 1000;
			isStarted = true;
			TimeSlot newslot = new TimeSlot();
			newslot.setHitCount(1);
			newslot.setTime(currentTime);
			synchronized (hitQueue) {
				hitQueue.add(newslot);
			}

			return;
		}
		TimeSlot aslot = hitQueue.getLast();
		if (aslot != null && aslot.time == currentTime) {
			aslot.hitCount++;
		} else {
			TimeSlot newslot = new TimeSlot();
			newslot.setHitCount(1);
			newslot.setTime(currentTime);
			synchronized (hitQueue) {
				hitQueue.add(newslot);
			}

		}
	}
}

class TimeSlot {
	long time;
	int hitCount;

	public TimeSlot() {

	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
}

class CleanupTask extends TimerTask {
	HitCounter hitCounter;

	public CleanupTask(HitCounter hitC) {
		hitCounter = hitC;
	}

	@Override
	public void run() {
		hitCounter.cleanUp();

	}

}

class GetHitTask extends TimerTask {

	HitCounter hitCounter;

	public GetHitTask(HitCounter hitC) {
		hitCounter = hitC;
	}

	@Override
	public void run() {
		int hits = hitCounter.getHits();
		System.out.println("Hits---->" + hits);

	}

}
