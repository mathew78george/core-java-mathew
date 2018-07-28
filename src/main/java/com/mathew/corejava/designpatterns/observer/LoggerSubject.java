package com.mathew.corejava.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class LoggerSubject {

	private String logString;

	public LoggerSubject() {

	}

	List<LoggerObserver> listeners = new ArrayList<LoggerObserver>();

	public void attach(LoggerObserver anObserver) {
		listeners.add(anObserver);
	}

	public void dettach(LoggerObserver anObserver) {
		listeners.remove(anObserver);
	}

	public void notifyObservers() {
		for (LoggerObserver aListener : listeners) {
			aListener.updateLog(logString);
		}
	}

	public void setLogString(String aStr) {
		logString = aStr;
		notifyObservers();
	}

}
