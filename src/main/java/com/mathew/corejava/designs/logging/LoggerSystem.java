package com.mathew.corejava.designs.logging;

public class LoggerSystem {

	private static LoggerSystem instance = null;
	static {
		getInstance();
	}

	private LoggerSystem() {

	}

	public static LoggerSystem getInstance() {
		if (instance == null) {
			synchronized (LoggerSystem.class) {
				instance = new LoggerSystem();
			}
		}
		return instance;
	}

	public static void logmessage(String message, LogLevel level) {
		LongDispatcher.getInstance().dispatchLogmessage(message, level);
	}

}
