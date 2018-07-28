package com.mathew.corejava.designpatterns.observer;

public class LogObserverFile extends LoggerObserver{
	
	public void updateLog(String aStr) {
		System.out.println("LogObserverFile Implementation updateLog " + aStr);
	}

}
