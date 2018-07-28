package com.mathew.corejava.designpatterns.observer;



public class LogObserverDB extends LoggerObserver {

	public void updateLog(String aStr) {
		System.out.println("LogObserverDB Implementation updateLog " + aStr);
	}
}
