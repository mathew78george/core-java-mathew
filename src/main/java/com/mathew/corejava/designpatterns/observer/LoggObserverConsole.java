package com.mathew.corejava.designpatterns.observer;

public class LoggObserverConsole extends LoggerObserver {

	public void updateLog(String aStr) {
		System.out.println("LoggObserverConsole Implementation updateLog " + aStr);
	}
}
