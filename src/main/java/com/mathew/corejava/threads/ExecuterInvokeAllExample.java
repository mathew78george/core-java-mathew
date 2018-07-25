package com.mathew.corejava.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterInvokeAllExample {

	public static void main(String[] args) {

		Callable<String> task1 = () -> {
			Thread.sleep(2000);
			return "Result from Task1";
		};

		Callable<String> task2 = () -> {
			Thread.sleep(2000);
			return "Result from Task2";
		};

		Callable<String> task3 = () -> {
			Thread.sleep(2000);
			return "Result from Task3";
		};
		List<Callable<String>> tasklist = Arrays.asList(task1, task2, task3);
		ExecutorService executer = Executors.newFixedThreadPool(5);
		try {
			List<Future<String>> futures = executer.invokeAll(tasklist);
			for (Future<String> aFuture : futures) {
				System.out.println(aFuture.get());
			}
			executer.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException ee) {

		}
	}
}
