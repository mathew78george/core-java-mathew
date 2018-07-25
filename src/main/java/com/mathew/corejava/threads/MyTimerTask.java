package com.mathew.corejava.threads;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("Timer Task started at " + new Date());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Timer Task completed at " + new Date());
	}

	public static void main(String[] args) {
		MyTimerTask task = new MyTimerTask();
		task.scheduledExecutionTime();
		Timer timer = new Timer("My Timer", true);
		timer.scheduleAtFixedRate(task, 0, 10*1000);
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("TimerTask cancelled");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}
