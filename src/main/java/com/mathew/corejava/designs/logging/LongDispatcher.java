package com.mathew.corejava.designs.logging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LongDispatcher {

	List<LoggerBase> logListeners;
	private static LongDispatcher instance = null;
	ExecutorService threadPoolExecuter;

	private LongDispatcher() {
		logListeners = new ArrayList<LoggerBase>();
		initialize(Arrays.asList(LoggingType.CONSOLE, LoggingType.DB, LoggingType.FILE));
		threadPoolExecuter = Executors.newCachedThreadPool();
	}

	public static LongDispatcher getInstance() {
		if (instance == null) {
			synchronized (LongDispatcher.class) {
				instance = new LongDispatcher();
			}
		}
		return instance;
	}

	public void initialize(List<LoggingType> types) {
		for (LoggingType aType : types) {
			LoggerBase loggerImpl = LoggerImplFactory.getLoggerImple(aType);
			logListeners.add(loggerImpl);
		}
	}

	public void dispatchLogmessage(String message, LogLevel level) {
		threadPoolExecuter.submit(new Runnable() {
			@Override
			public void run() {
				for (LoggerBase logger : logListeners) {
					switch (level) {
					case DEBUG:
						logger.logDebug(message);
						break;
					case INFO:
						logger.logInfo(message);
						break;
					case ERROR:
						logger.logError(message);
						break;
					case WARNING:
						logger.logWarning(message);
						break;

					default:
						break;
					}
				}

			}
		});

	}
}
