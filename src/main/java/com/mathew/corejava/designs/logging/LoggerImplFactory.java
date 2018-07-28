package com.mathew.corejava.designs.logging;

public class LoggerImplFactory {

	public static LoggerBase getLoggerImple(LoggingType type) {
		LoggerBase loggerImpl = null;
		switch (type) {
		case DB:
			loggerImpl = new DBLogger();
			break;
		case CONSOLE:
			loggerImpl = new ConsoleLogger();
			break;
		case FILE:
			loggerImpl = new FileLogger("logfile.txt");
			break;

		default:
			break;
		}
		return loggerImpl;
	}

}
