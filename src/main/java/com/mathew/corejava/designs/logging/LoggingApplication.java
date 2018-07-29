package com.mathew.corejava.designs.logging;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LoggingApplication {

	public static void main(String[] args) {
		LoggingTask task1 = new LoggingTask(LogLevel.DEBUG, "Debug Logger");
		LoggingTask task2 = new LoggingTask(LogLevel.INFO, "Info Logger");
		LoggingTask task3 = new LoggingTask(LogLevel.ERROR, "Error Logger");
		LoggingTask task4 = new LoggingTask(LogLevel.WARNING, "Warning Logger");
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> stat1 = executorService.submit(task1);
		Future<String> stat2 = executorService.submit(task2);
		Future<String> stat3 = executorService.submit(task3);
		Future<String> stat4 = executorService.submit(task4);
		System.out.println(stat1);
		System.out.println(stat2);
		System.out.println(stat3);
		System.out.println(stat4);
		executorService.shutdown();
	}

}

class LoggingTask implements Callable<String> {
	private LogLevel level;
	private String name;

	public LoggingTask(LogLevel lvl, String n) {
		level = lvl;
		name = n;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Inside call of " + name);
		for (int ii = 0; ii <= 1000; ii++) {
			LoggerSystem.logmessage("The " + level + " Message " + ii + " from " + name, level);
		}
		return "Done";
	}
}
