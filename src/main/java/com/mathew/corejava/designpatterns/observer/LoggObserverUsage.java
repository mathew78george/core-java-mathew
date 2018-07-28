package com.mathew.corejava.designpatterns.observer;

public class LoggObserverUsage {
	
	public static void main(String[] args) {
		LoggerSubject subject = new LoggerSubject();
		LoggObserverConsole console = new LoggObserverConsole();
		LogObserverDB db = new LogObserverDB();
		LogObserverFile file = new LogObserverFile();
		subject.attach(console);
		subject.attach(db);
		subject.attach(file);
		subject.setLogString("Mathew");
		subject.setLogString("George");
		
	}

}
